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

    @JsonProperty("hipr")
    private String annualHigh;

    @JsonProperty("lopr")
    private String annualLow;

    @JsonProperty("lstgStCnt")
    private String numberOfStock;

    @JsonProperty("mrktTotAmt")
    private String totalAmount;

    @JsonProperty("clpr")
    private String PER;

}
