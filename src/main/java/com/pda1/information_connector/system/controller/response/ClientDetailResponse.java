package com.pda1.information_connector.system.controller.response;

import com.pda1.information_connector.korea_investment.controller.response.ChartResponse;
import com.pda1.information_connector.korea_investment.controller.response.MainChartResponse;
import com.pda1.information_connector.shinhan.controller.response.ChartCommentResponse;
import com.pda1.information_connector.shinhan.controller.response.ChartTableResponse;
import com.pda1.information_connector.shinhan.controller.response.StatementCommentResponse;
import com.pda1.information_connector.shinhan.controller.response.StatementResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class ClientDetailResponse {

    private MainChartResponse mainChartResponse;
    private ChartCommentResponse chartCommentResponse;
    private StatementResponse statementResponse;
    private StatementCommentResponse statementCommentResponse;
    private ChartTableResponse chartTableResponse;

}
