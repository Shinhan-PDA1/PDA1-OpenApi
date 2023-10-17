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
    private String type;
    private String question;

    public ChatbotRequestDTO toServiceDto(){
        return ChatbotRequestDTO.of(userId,type,question);
    }
}
