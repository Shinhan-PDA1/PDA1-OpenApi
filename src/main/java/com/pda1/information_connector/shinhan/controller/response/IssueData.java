package com.pda1.information_connector.shinhan.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class IssueData {

    @JsonProperty("rank")
    private int rank;

    @JsonProperty("stbd_nm")
    private String stockName;


    @JsonProperty("stock_code")
    private String stockCode;

}
