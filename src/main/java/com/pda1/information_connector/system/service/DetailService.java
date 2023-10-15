package com.pda1.information_connector.system.service;

import com.pda1.information_connector.korea_investment.controller.response.MainChartResponse;
import com.pda1.information_connector.korea_investment.service.KoreaInvestApiService;
import com.pda1.information_connector.system.controller.response.ClientChartResponse;
import com.pda1.information_connector.system.controller.response.ClientDetailResponse;
import com.pda1.information_connector.system.controller.response.ClientStatementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
@RequiredArgsConstructor
public class DetailService {

    private final KoreaInvestApiService koreaInvestApiService;

    public ClientDetailResponse getDetailInformation(String code) {

        // 차트 데이터

        // 차트 해설 데이터

        // 재무제표 데이터

        // 재무제표 해설 데이터

        return null;

    }

    public ClientStatementResponse getStatementInformation(String code) {

        return null;
    }

    public ClientChartResponse getChartInformation(String code) throws ParseException {

        // 차트 데이터 받아오기
        MainChartResponse chartResponse = koreaInvestApiService.getChartData(code);

        // 차트 해설 받아오기


        return ClientChartResponse.builder()
                                    .oepnai_response(null)
                                    .response(chartResponse)
                                    .build();
    }
}
