package com.pda1.information_connector.korea_investment.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pda1.information_connector.korea_investment.service.dto.Output2;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class MainChartResponse {

    private List<ChartData> chartData = new ArrayList<>();

}
