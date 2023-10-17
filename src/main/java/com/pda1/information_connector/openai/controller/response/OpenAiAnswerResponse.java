package com.pda1.information_connector.openai.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiAnswerResponse {

    private String response;

    public void updateResponse(String response){
        this.response = response;
    }

}
