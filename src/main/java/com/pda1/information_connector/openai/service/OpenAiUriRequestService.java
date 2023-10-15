package com.pda1.information_connector.openai.service;


import com.pda1.information_connector.openai.service.dto.ChatbotAnswerDto;
import com.pda1.information_connector.openai.service.dto.ChatbotRequestDTO;
import com.pda1.information_connector.shinhan.controller.response.*;
import com.pda1.information_connector.shinhan.service.ShinhanUriBuilderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class OpenAiUriRequestService {

    public final OpenAiUriBuilderService uriBuilderService;

    public ChatbotAnswerDto getWordAnswer(ChatbotRequestDTO requestDTO) {

        URI uri = uriBuilderService.buildWordUri();

        String jsonRequest = "{" + "\"word\": " + "\"" + requestDTO.getContent() + "\"" + "}";
        System.out.println(jsonRequest);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>(jsonRequest, headers);

        return new RestTemplate().exchange(uri, HttpMethod.POST, httpEntity, ChatbotAnswerDto.class).getBody();

    }
    public ChatbotAnswerDto getQuestionAnswer(ChatbotRequestDTO requestDTO) {

        URI uri = uriBuilderService.buildQuestionUri();

        String jsonRequest = "{" + "\"question\": " + "\"" + requestDTO.getContent() + "\"" + "}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>(jsonRequest, headers);

        return new RestTemplate().exchange(uri, HttpMethod.POST, httpEntity, ChatbotAnswerDto.class).getBody();

    }
}
