package com.pda1.information_connector.ksd.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StockInfoItems {
    @JsonProperty("items")
    private StockInfoItem stockInfoItem;
}
