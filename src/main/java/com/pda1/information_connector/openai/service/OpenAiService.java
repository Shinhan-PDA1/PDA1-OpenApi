package com.pda1.information_connector.openai.service;

import com.pda1.information_connector.domain.chat_log.ChatLog;
import com.pda1.information_connector.domain.chat_log.ChatLogRepository;
import com.pda1.information_connector.domain.word_cache.WordCache;
import com.pda1.information_connector.domain.word_cache.WordCacheRepository;
import com.pda1.information_connector.openai.controller.response.OpenAiAnswerResponse;
import com.pda1.information_connector.openai.service.dto.ChatbotAnswerDto;
import com.pda1.information_connector.openai.service.dto.ChatbotRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OpenAiService {

    private final OpenAiUriRequestService openAiUriRequestService;
    private final ChatLogRepository chatLogRepository;
    private final WordCacheRepository wordCacheRepository;

    public OpenAiAnswerResponse saveConversationAndGetAnswer(ChatbotRequestDTO request) {

        OpenAiAnswerResponse response = new OpenAiAnswerResponse();

        // 1. 개념 질문인지, 용어 질문인지
        if(request.getType().equals("word")){

            // 2. 용어 질문이면 캐시 테이블에 존재하는지 확인
            // 2-1. 캐시 테이블에 존재하는 용어 질문이면 가져옴
            WordCache word = wordCacheRepository.findByWord(request.getQuestion()).orElse(null);

            // 2-2. 캐시 테이블에 데이터가 없으면
            if(Objects.isNull(word)){
                // Open Ai api 호출해서 답변 받아옴
                ChatbotAnswerDto answer = openAiUriRequestService.getWordAnswer(request);
                response.updateResponse(answer.getAnswer());
                wordCacheRepository.save(WordCache.builder().word(request.getQuestion()).description(answer.getAnswer()).build());
            }
            else {  // 캐시에 데이터가 있으면
                // 캐시 데이터 response에 담아줌
                response.updateResponse(word.getDescription());
            }
        }
        else{
            // 3. 개념 질문이면
            ChatbotAnswerDto answer = openAiUriRequestService.getQuestionAnswer(request);
            response.updateResponse(answer.getAnswer());
        }

        // 4. 결과를 DB에 저장
        chatLogRepository.save(ChatLog.builder()
                                        .userId(request.getUserId())
                                        .requestType(request.getType())
                                        .requestContent(request.getQuestion())
                                        .requestDescription(response.getResponse())
                                        .build());

        // 5. 생성된 응답을 다시 클라이언트에 반환
        return response;
    }

    public boolean saveAnalysisResult(String code) throws URISyntaxException {
        // 향후 uri 수정 필요
        URI forFinancialStatements = new URI("http://localhost:5500/api/v1/crawling");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUri(forFinancialStatements)
                .queryParam("code", code);
        URI finalUriForFinancialStatements = uriBuilder.build().toUri();

        String jsonResponseFinance = new RestTemplate().exchange(finalUriForFinancialStatements, HttpMethod.POST, httpEntity, String.class).getBody();

        // 다시 OpenAI 호출
        URI forOpenAIAnalysis = new URI("http://localhost:5000/api/v1/openai/analysis");

        uriBuilder = UriComponentsBuilder.fromUri(forOpenAIAnalysis)
                .queryParam("data", jsonResponseFinance);
        URI finalUriForOpenAIAnalyse = uriBuilder.build().toUri();

        String jsonResponseOpenAI = new RestTemplate().exchange(finalUriForOpenAIAnalyse, HttpMethod.POST, httpEntity, String.class).getBody();

        return true;
    }
}

