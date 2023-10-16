package com.pda1.information_connector.ksd.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StockInfoDTO {

    @JsonProperty("itmsNm")
    private String stockName;

    @JsonProperty("srtnCd")
    private String stockNumber;

    @JsonProperty("mrktCtg")
    private String stockMarket;
}
