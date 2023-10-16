package com.pda1.information_connector.shinhan.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class StatementResponse {

    private String type;
    private String date;
    private String bps;
    private String eps;
    private String pbr;
    private String per;
    private String roe;
    private String net_income;
    private String quick_ratio;
    private String sales;
    private String dividend_payout_ratio;
    private String debt_ratio;
    private String net_profit_margin;
    private String market_odds;
    private String operation_profit_margin;
    private String retention_rate;
    private String dividend_per_share;

}
