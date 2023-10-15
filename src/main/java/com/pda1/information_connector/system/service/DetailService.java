package com.pda1.information_connector.system.service;

import com.pda1.information_connector.domain.chart_comment.ChartComment;
import com.pda1.information_connector.domain.chart_comment.ChartCommentRepository;
import com.pda1.information_connector.domain.chart_table.ChartTableRepository;
import com.pda1.information_connector.domain.statement.StatementRepository;
import com.pda1.information_connector.domain.statement_comment.StatementCommentRepository;
import com.pda1.information_connector.domain.stock_info.StockInformation;
import com.pda1.information_connector.domain.stock_info.StockInformationRepository;
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
//
//    private final KoreaInvestApiService koreaInvestApiService;
//    private final ChartTableRepository chartTableRepository;
//    private final ChartCommentRepository chartCommentRepository;
//    private final StatementRepository statementRepository;
//    private final StatementCommentRepository statementCommentRepository;
//    private final StockInformationRepository stockInformationRepository;


    public ClientDetailResponse getDetailInformation(String code) throws Throwable {

        // 차트 데이터
//        MainChartResponse chartResponse = koreaInvestApiService.getChartData(code);
//
        // 차트 해설 데이터
//        StockInformation stockInformation = stockInformationRepository.findByStockCode(code).orElseThrow(()->new IllegalArgumentException("존재하지 않는 종목입니다."));
        //ChartComment chartComment = chartCommentRepository.findByStockInfortmation(stockInformation).orElseThrow(()->new IllegalArgumentException("존재하지 않는 종목입니다."));
        
        // 재무제표 데이터

        
        // 재무제표 해설 데이터
        
        
        // 차트 표 데이터


        return null;

    }

    public ClientStatementResponse getStatementInformation(String code) {

        return null;
    }

//    public ClientChartResponse getChartInformation(String code) throws ParseException {
//
//        // 차트 데이터 받아오기
//        MainChartResponse chartResponse = koreaInvestApiService.getChartData(code);
//
//        // 차트 해설 받아오기
//
//
//        return ClientChartResponse.builder()
//                                    .oepnai_response(null)
//                                    .response(chartResponse)
//                                    .build();
//    }
}
