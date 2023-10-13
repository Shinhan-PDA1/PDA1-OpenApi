package com.pda1.information_connector.korea_investment.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class ChartData {

    private String date;
    private String open_price;
    private String close_price;
    private String high_price;
    private String low_price;
    private String trading_volume;

}
