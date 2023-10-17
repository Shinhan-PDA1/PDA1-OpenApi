package com.pda1.information_connector.system.service;

import com.pda1.information_connector.domain.chart_comment.ChartComment;
import com.pda1.information_connector.domain.chart_comment.ChartCommentRepository;
import com.pda1.information_connector.domain.chart_table.ChartTable;
import com.pda1.information_connector.domain.chart_table.ChartTableRepository;
import com.pda1.information_connector.domain.chat_log.ChatLog;
import com.pda1.information_connector.domain.chat_log.ChatLogRepository;
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
import com.pda1.information_connector.system.controller.response.GuideResponse;
import com.pda1.information_connector.system.service.dto.GuideDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuideService {

    private final ChatLogRepository chatLogRepository;
    public GuideResponse getGuideInformation(Long userId) {

        GuideResponse response = new GuideResponse();

        List<ChatLog> chatLogList = chatLogRepository.findAllByUserId(userId);

        chatLogList.stream().forEach(
                log -> response.getResponse().add(
                        GuideDTO.builder()
                                .type(log.getRequestType())
                                .question(log.getRequestContent())
                                .description(log.getRequestDescription())
                                .build()));

        return response;
    }
}
