package com.pda1.information_connector.openai.controller.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OpenAiAnswerResponse {

    private String answer;
    private String processing_time;

}
