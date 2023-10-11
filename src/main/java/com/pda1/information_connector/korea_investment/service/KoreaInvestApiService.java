package com.pda1.information_connector.korea_investment.service;

import com.pda1.information_connector.korea_investment.controller.response.ChartResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KoreaInvestApiService {

    private final UriRequestService uriRequestService;
    private String ACCESS_TOKEN = null;

    public void tokenCheck(){
        if(ACCESS_TOKEN == null){
            ACCESS_TOKEN = uriRequestService.requestToken().getAccessToken();
        }
    }

    public ChartResponse getChartData(String code) {
        tokenCheck();
        System.out.println("asd : " + ACCESS_TOKEN);
        ChartResponse response = uriRequestService.getChartData(code, ACCESS_TOKEN);
        System.out.println(response.getOutput1().getAcml_tr_pbmn());
        return response;
    }
}
