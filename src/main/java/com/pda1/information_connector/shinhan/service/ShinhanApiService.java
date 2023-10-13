package com.pda1.information_connector.shinhan.service;

import com.pda1.information_connector.shinhan.controller.response.PortfolioResponse;
import com.pda1.information_connector.shinhan.controller.response.MainPortfolioResponse;
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

        PortfolioResponse response = uriRequestService.getPortfolio();

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
}
