package com.pda1.information_connector.shinhan.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class MainPopularResponse {

    private String stock_code;
    private String stock_name;
    private String variable_ranking;
    private String ranking;
    private String count;
    private String category;

}
