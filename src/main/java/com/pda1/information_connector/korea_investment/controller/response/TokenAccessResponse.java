package com.pda1.information_connector.korea_investment.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TokenAccessResponse {

    @JsonProperty("access_token")
    private String accessToken;
}
