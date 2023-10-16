package com.pda1.information_connector.ksd.service;

import com.pda1.information_connector.domain.stock_info.StockInformation;
import com.pda1.information_connector.domain.stock_info.StockInformationRepository;
import com.pda1.information_connector.ksd.controller.response.StockInfoItems;
import com.pda1.information_connector.ksd.controller.response.StockInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class KSDApiService {

    private final KSDUriRequestService uriRequestService;
    private final StockInformationRepository stockInformationRepository;

    public boolean saveKSDStockData() throws UnsupportedEncodingException, URISyntaxException {
        System.out.println("Service Start");
        StockInfoResponse kospi_response = uriRequestService.getKospiStockInfo();
        System.out.println("Service End");

        int numOfRows = 0;
        kospi_response.getStockInfoBody().getStockInfoItems().getStockInfoItem().getItem().forEach(item -> {
            System.out.println("Number: "+ item.getStockNumber());
            System.out.println("Name: " + item.getStockName());

            StockInformation stockInformation = new StockInformation(item.getStockName(), item.getStockNumber());
            stockInformationRepository.save(stockInformation);
        });
        return true;
    }


}
