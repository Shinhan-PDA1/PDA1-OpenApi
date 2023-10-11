package com.pda1.information_connector.korea_investment.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pda1.information_connector.korea_investment.service.dto.Output1;
import com.pda1.information_connector.korea_investment.service.dto.Output2;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public class ChartResponse {

    @JsonProperty("output1")
    private Output1 output1;

    @JsonProperty("output2")
    private List<Output2> output2;

}
