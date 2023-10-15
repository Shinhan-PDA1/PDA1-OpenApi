package com.pda1.information_connector.openai.service.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatbotRequestDTO {

    private Long userId;
    private String userName;
    private String requestType;
    private String content;

    public static ChatbotRequestDTO of(Long userId, String userName, String requestType, String content){
        return new ChatbotRequestDTO(userId,userName,requestType,content);
    }

}
