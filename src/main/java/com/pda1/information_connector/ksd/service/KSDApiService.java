package com.pda1.information_connector.ksd.service;

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
    private final ChartTableRepository chartTableRepository;
    private final ChartCommentRepository chartCommentRepository;
    private final StatementCommentRepository statementCommentRepository;
    private final StatementRepository statementRepository;

    public boolean saveKSDStockData() throws UnsupportedEncodingException, URISyntaxException {

        StockInfoResponse kospi_response = uriRequestService.getKospiStockInfo();

        kospi_response.getStockInfoBody().getStockInfoItems().getStockInfoItem().getItem().forEach(item -> {
            System.out.println("Number: "+ item.getStockNumber());
            System.out.println("Name: " + item.getStockName());

            StockInformation stockInformation = new StockInformation(item.getStockName(), item.getStockNumber());
            stockInformationRepository.save(stockInformation);

            ChartTable chartTable = new ChartTable(
                    item.getStockMarket(),
                    item.getAnnualHigh(),
                    item.getAnnualLow(),
                    item.getNumberOfStock(),
                    item.getTotalAmount(),
                    item.getPER()
            );
            chartTable.setStockInformation(stockInformation);
            chartTableRepository.save(chartTable);

            ChartComment chartComment = new ChartComment(

            );
            chartComment.setStockInformation(stockInformation);
            chartCommentRepository.save(chartComment);

            StatementComment statementComment = new StatementComment(

            );
            statementComment.setStockInformation(stockInformation);
            statementCommentRepository.save(statementComment);

            Statement statement = new Statement(

            );
            statementComment.setStockInformation(stockInformation);
            statementRepository.save(statement);

        });
        return true;
    }

}
