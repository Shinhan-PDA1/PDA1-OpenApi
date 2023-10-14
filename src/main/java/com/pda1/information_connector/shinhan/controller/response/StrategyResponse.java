package com.pda1.information_connector.shinhan.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StrategyResponse {

    @JsonProperty("dataBody")
    private StrategyDataBody strategyDataBody;

}
