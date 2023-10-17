package com.pda1.information_connector.system.service;

import com.pda1.information_connector.domain.chart_comment.ChartComment;
import com.pda1.information_connector.domain.chart_comment.ChartCommentRepository;
import com.pda1.information_connector.domain.chart_table.ChartTable;
import com.pda1.information_connector.domain.chart_table.ChartTableRepository;
import com.pda1.information_connector.domain.statement.Statement;
import com.pda1.information_connector.domain.statement.StatementRepository;
import com.pda1.information_connector.domain.statement_comment.StatementComment;
import com.pda1.information_connector.domain.statement_comment.StatementCommentRepository;
import com.pda1.information_connector.domain.stock_info.StockInformation;
import com.pda1.information_connector.domain.stock_info.StockInformationRepository;
import com.pda1.information_connector.korea_investment.controller.response.MainChartResponse;
import com.pda1.information_connector.korea_investment.service.KoreaInvestApiService;
import com.pda1.information_connector.shinhan.controller.response.ChartCommentResponse;
import com.pda1.information_connector.shinhan.controller.response.ChartTableResponse;
import com.pda1.information_connector.shinhan.controller.response.StatementCommentResponse;
import com.pda1.information_connector.shinhan.controller.response.StatementResponse;
import com.pda1.information_connector.system.controller.response.ClientDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailService {

    private final KoreaInvestApiService koreaInvestApiService;
    private final ChartTableRepository chartTableRepository;
    private final ChartCommentRepository chartCommentRepository;
    private final StatementRepository statementRepository;
    private final StatementCommentRepository statementCommentRepository;
    private final StockInformationRepository stockInformationRepository;


    public ClientDetailResponse getDetailInformation(String code) throws Throwable {

        // 차트 데이터
        MainChartResponse chartResponse = koreaInvestApiService.getChartData(code);

        // 차트 해설 데이터
        StockInformation stockInformation = stockInformationRepository.findByStockCode(code).orElseThrow(()->new IllegalArgumentException("존재하지 않는 종목입니다."));
        ChartComment chartComment = chartCommentRepository.findByStockInformation(stockInformation).orElseThrow(()->new IllegalArgumentException("존재하지 않는 종목입니다."));
        ChartCommentResponse chartCommentResposne = ChartCommentResponse.builder().chart_long_comment(chartComment.getLongComment()).chart_short_comment(chartComment.getShortComment()).build();

        // 재무제표 데이터
        Statement statement = statementRepository.findByStockInformation(stockInformation).orElseThrow(()->new IllegalArgumentException("존재하지 않는 종목입니다."));
        StatementResponse statementResponse = StatementResponse.builder()
                                                                .type(statement.getType())
                                                                .date(statement.getDate())
                                                                .bps(statement.getBps())
                                                                .eps(statement.getEps())
                                                                .pbr(statement.getPbr())
                                                                .per(statement.getPer())
                                                                .roe(statement.getRoe())
                                                                .net_income(statement.getNetIncome())
                                                                .quick_ratio(statement.getQuickRatio())
                                                                .sales(statement.getSales())
                                                                .dividend_payout_ratio(statement.getDividendPayoutRatio())
                                                                .debt_ratio(statement.getDebtRatio())
                                                                .net_profit_margin(statement.getNetProfitMargin())
                                                                .market_odds(statement.getMarketOdds())
                                                                .operation_profit_margin(statement.getOperationProfitMargin())
                                                                .retention_rate(statement.getRetentionRate())
                                                                .dividend_per_share(statement.getDividendPerShare())
                                                                .build();
        // 재무제표 해설 데이터
        StatementComment statementComment = statementCommentRepository.findByStockInformation(stockInformation).orElseThrow(()->new IllegalArgumentException("존재하지 않는 종목입니다."));
        StatementCommentResponse statementCommentResponse = StatementCommentResponse.builder().statement_long_comment(statementComment.getLongComment()).statement_short_comment(statementComment.getShortComment()).build();

        // 차트 표 데이터
        ChartTable chartTable = chartTableRepository.findByStockInformation(stockInformation).orElseThrow(()->new IllegalArgumentException("존재하지 않는 종목입니다."));
        ChartTableResponse chartTableResponse = ChartTableResponse.builder()
                                                                    .annual_high(chartTable.getAnnualHigh())
                                                                    .annual_low(chartTable.getAnnualLow())
                                                                    .capital(chartTable.getCapital())
                                                                    .stock_market(chartTable.getStockMarket())
                                                                    .market_capital(chartTable.getMarketCapital())
                                                                    .listed_stock_number(chartTable.getListedStockNumber())
                                                                    .per(chartTable.getPer())
                                                                    .eps(chartTable.getEps())
                                                                    .build();

        return ClientDetailResponse.builder()
                .mainChartResponse(chartResponse)
                .chartCommentResponse(chartCommentResposne)
                .statementResponse(statementResponse)
                .statementCommentResponse(statementCommentResponse)
                .chartTableResponse(chartTableResponse)
                .build();

    }

    public String getStockCode(String stockName) {

        StockInformation stockInformation = stockInformationRepository.findByStockName(stockName).orElseThrow(()->new IllegalArgumentException("존재하지 않는 종목입니다."));

        return stockInformation.getStockCode();
    }
}
