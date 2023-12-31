package com.pda1.information_connector.shinhan.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class MainPortfolioResponse {

    private String stock_code;
    private String revenue_rate;
    private String stock_name;
    private String transfer_date;
    private String transfer_price;

}
