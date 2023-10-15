package com.pda1.information_connector.openai.controller.request;

import com.pda1.information_connector.openai.service.dto.ChatbotRequestDTO;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatbotRequest {

    private Long userId;
    private String userName;
    private String requestType;
    private String content;

    public ChatbotRequestDTO toServiceDto(){
        return ChatbotRequestDTO.of(userId,userName,requestType,content);
    }
}
