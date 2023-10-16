package com.pda1.information_connector.ksd.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pda1.information_connector.ksd.service.dto.StockInfoDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class StockInfoItem {
    @JsonProperty("item")
    private List<StockInfoDTO> item;
}
