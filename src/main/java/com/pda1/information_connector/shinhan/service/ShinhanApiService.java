package com.pda1.information_connector.shinhan.service;

import com.pda1.information_connector.shinhan.controller.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShinhanApiService {

    private final ShinhanUriRequestService uriRequestService;

    public List<MainPortfolioResponse> getPortfolio() {

        List<MainPortfolioResponse> mainResponse = new ArrayList<>();

        DataBodyResponse response = uriRequestService.getPortfolio();

        response.getDataBody().getList().stream().forEach(
                data -> mainResponse.add(
                        MainPortfolioResponse.builder()
                                .stock_code(data.getStock_code())
                                .stock_name(data.getStbd_name())
                                .revenue_rate(data.getReve_rt())
                                .transfer_date(data.getIncp_ymd())
                                .transfer_price(data.getIncp_prc())
                                .build()
                )
        );

        return mainResponse;
    }

    public List<MainPopularResponse> getPopular() {

        List<MainPopularResponse> mainResponse = new ArrayList<>();

        PopularResponse response = uriRequestService.getPopular();

        response.getPopularDataBody().getList().stream().forEach(
                data -> mainResponse.add(
                        MainPopularResponse.builder()
                                .stock_code(data.getStockCode())
                                .stock_name(data.getStockName())
                                .category(data.getCategory())
                                .count(data.getCount())
                                .ranking(data.getRanking())
                                .variable_ranking(data.getVariableRanking())
                                .build()
                )
        );

        return mainResponse;
    }

    public List<MainIssueResponse> getIssue(String query) {

        List<MainIssueResponse> mainResponse = new ArrayList<>();

        IssueResponse response = uriRequestService.getIssue(query);

        response.getIssueDataBody().getList().stream().forEach(
                data -> mainResponse.add(
                        MainIssueResponse.builder()
                                .stock_code(data.getStockCode())
                                .stock_name(data.getStockName())
                                .rank(data.getRank())
                                .build()
                )
        );

        return mainResponse;
    }
}
