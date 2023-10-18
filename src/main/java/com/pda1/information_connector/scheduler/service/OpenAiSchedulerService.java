package com.pda1.information_connector.scheduler.service;

import com.pda1.information_connector.domain.chart_comment.ChartComment;
import com.pda1.information_connector.domain.chart_comment.ChartCommentRepository;
import com.pda1.information_connector.domain.statement_comment.StatementComment;
import com.pda1.information_connector.domain.statement_comment.StatementCommentRepository;
import com.pda1.information_connector.domain.stock_info.StockInformation;
import com.pda1.information_connector.domain.stock_info.StockInformationRepository;
import com.pda1.information_connector.openai.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenAiSchedulerService {

    private final StockInformationRepository stockInformationRepository;
    private final ChartCommentRepository chartCommentRepository;
    private final StatementCommentRepository statementCommentRepository;



    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul")
    public void startChartScheduling(){
        System.out.println("@@@@@@ UPDATE START @@@@@@");

        StockInformation stock = stockInformationRepository.findByStockCode("005930").orElseThrow(()->new IllegalArgumentException("존재하지 않는 종목입니다."));
        ChartComment comment = chartCommentRepository.findByStockInformation(stock).orElseThrow(()->new IllegalArgumentException("존재하지 않는 해설입니다."));

        chartCommentRepository.save(comment);

        System.out.println("@@@@@@ UPDATE END @@@@@@");
    }

    @Scheduled(cron = "0 0 0 1 */6 ?", zone = "Asia/Seoul")
    public void startStatementScheduling(){
        System.out.println("@@@@@@ UPDATE START @@@@@@");

        StockInformation stock = stockInformationRepository.findByStockCode("005930").orElseThrow(()->new IllegalArgumentException("존재하지 않는 종목입니다."));
        StatementComment comment = statementCommentRepository.findByStockInformation(stock).orElseThrow(()->new IllegalArgumentException("존재하지 않는 해설입니다."));

        statementCommentRepository.save(comment);

        System.out.println("@@@@@@ UPDATE END @@@@@@");
    }

}
