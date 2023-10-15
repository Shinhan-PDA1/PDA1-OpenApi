package com.pda1.information_connector.openai.controller;

import com.pda1.information_connector.openai.controller.request.ChatbotRequest;
import com.pda1.information_connector.openai.controller.response.OpenAiAnswerResponse;
import com.pda1.information_connector.openai.service.OpenAiService;
import com.pda1.information_connector.shinhan.controller.response.MainPortfolioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chatbot")
public class OpenAiController {

    private final OpenAiService openAiService;

    @PostMapping("/word")
    public ResponseEntity<?> requestWord(@RequestBody ChatbotRequest request) {
        OpenAiAnswerResponse response= openAiService.requestWord(request.toServiceDto());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/question")
    public ResponseEntity<?> requestQuestion(@RequestBody ChatbotRequest request) {
        OpenAiAnswerResponse response= openAiService.requestQuestion(request.toServiceDto());
        return ResponseEntity.ok(response);
    }

}
