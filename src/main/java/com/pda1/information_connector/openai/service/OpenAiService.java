package com.pda1.information_connector.openai.service;

import com.pda1.information_connector.domain.chat_log.ChatLog;
import com.pda1.information_connector.domain.chat_log.ChatLogRepository;
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

@Service
@RequiredArgsConstructor
public class OpenAiService {

    private final OpenAiUriRequestService openAiUriRequestService;
    private final ChatLogRepository chatLogRepository;

    public OpenAiAnswerResponse requestWord(ChatbotRequestDTO requestDTO) {

        System.out.println("@@@@@@@@@@@");
        ChatbotAnswerDto answer = openAiUriRequestService.getWordAnswer(requestDTO);

        System.out.println("asd : " + answer.getAnswer());
        // DB에 저장을 한다.
        chatLogRepository.save(ChatLog.builder()
                                        .userId(requestDTO.getUserId())
                                        .userName(requestDTO.getUserName())
                                        .requestType(requestDTO.getRequestType())
                                        .requestContent(requestDTO.getContent())
                                        .requestDescription(answer.getAnswer())
                                        .build());

        return OpenAiAnswerResponse.builder()
                                    .answer(answer.getAnswer())
                                    .processing_time(answer.getProcessing_time())
                                    .build();
    }

    public OpenAiAnswerResponse requestQuestion(ChatbotRequestDTO requestDTO) {

        ChatbotAnswerDto answer = openAiUriRequestService.getQuestionAnswer(requestDTO);

        // DB에 저장을 한다.
        chatLogRepository.save(ChatLog.builder()
                                        .userId(requestDTO.getUserId())
                                        .userName(requestDTO.getUserName())
                                        .requestType(requestDTO.getRequestType())
                                        .requestContent(requestDTO.getContent())
                                        .requestDescription(answer.getAnswer())
                                        .build());

        return OpenAiAnswerResponse.builder()
                .answer(answer.getAnswer())
                .processing_time(answer.getProcessing_time())
                .build();
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
