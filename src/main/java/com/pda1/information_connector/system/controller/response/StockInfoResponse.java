package com.pda1.information_connector.system.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class StockInfoResponse {

    private String stockName;
    private String price;
    private String rate;

}
