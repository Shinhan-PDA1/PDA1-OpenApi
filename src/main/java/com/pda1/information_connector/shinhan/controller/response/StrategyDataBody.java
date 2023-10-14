package com.pda1.information_connector.shinhan.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pda1.information_connector.shinhan.service.dto.IssueDataDTO;
import com.pda1.information_connector.shinhan.service.dto.StrategyDataDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class StrategyDataBody {

    @JsonProperty("list")
    private List<StrategyDataDTO> list;

}
