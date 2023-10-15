package com.pda1.information_connector.openai.service;

import com.pda1.information_connector.domain.chat_log.ChatLog;
import com.pda1.information_connector.domain.chat_log.ChatLogRepository;
import com.pda1.information_connector.openai.controller.response.OpenAiAnswerResponse;
import com.pda1.information_connector.openai.service.dto.ChatbotAnswerDto;
import com.pda1.information_connector.openai.service.dto.ChatbotRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
