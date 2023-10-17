package com.pda1.information_connector.openai.service.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatbotRequestDTO {

    private Long userId;
    private String type;
    private String question;

    public static ChatbotRequestDTO of(Long userId, String type, String question){
        return new ChatbotRequestDTO(userId,type,question);
    }

}
