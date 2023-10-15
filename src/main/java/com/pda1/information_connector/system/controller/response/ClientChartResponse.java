package com.pda1.information_connector.system.controller.response;

import com.pda1.information_connector.korea_investment.controller.response.MainChartResponse;
import lombok.*;


@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ClientChartResponse {

    private String oepnai_response;
    private MainChartResponse response;

}
