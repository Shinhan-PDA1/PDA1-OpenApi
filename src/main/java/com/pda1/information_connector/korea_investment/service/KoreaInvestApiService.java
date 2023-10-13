package com.pda1.information_connector.korea_investment.service;

import com.pda1.information_connector.korea_investment.controller.response.ChartData;
import com.pda1.information_connector.korea_investment.controller.response.ChartResponse;
import com.pda1.information_connector.korea_investment.controller.response.MainChartResponse;
import com.pda1.information_connector.korea_investment.service.dto.Output2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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

    public MainChartResponse getChartData(String code) throws ParseException {
        tokenCheck();

        MainChartResponse mainChartResponse = new MainChartResponse();

        ChartResponse response = uriRequestService.getChartData(code, ACCESS_TOKEN);

        response.getOutput2()
                .stream()
                .forEach(
                        data -> mainChartResponse.getChartData().add(
                                ChartData.builder()
                                    .date(data.getStck_bsop_date())
                                    .open_price(data.getStck_oprc())
                                    .close_price(data.getStck_clpr())
                                    .low_price(data.getStck_lwpr())
                                    .high_price(data.getStck_hgpr())
                                    .trading_volume(data.getAcml_vol())
                                .build())
        );

        String date = response.getOutput2().get(response.getOutput2().size()-1).getStck_bsop_date();

        ChartResponse response2 = uriRequestService.getSecondChartData(code, ACCESS_TOKEN, date);

        response2.getOutput2()
                .stream()
                .forEach(
                        data -> mainChartResponse.getChartData().add(
                                ChartData.builder()
                                        .date(data.getStck_bsop_date())
                                        .open_price(data.getStck_oprc())
                                        .close_price(data.getStck_clpr())
                                        .low_price(data.getStck_lwpr())
                                        .high_price(data.getStck_hgpr())
                                        .trading_volume(data.getAcml_vol())
                                        .build())
                );

        return mainChartResponse;
    }
}
