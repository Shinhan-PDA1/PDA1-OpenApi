package com.pda1.information_connector.shinhan.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class ChartTableResponse {

    private String annual_high;
    private String annual_low;
    private String capital;
    private String listed_stock_number;
    private String market_capital;
    private String per;
    private String eps;
}
