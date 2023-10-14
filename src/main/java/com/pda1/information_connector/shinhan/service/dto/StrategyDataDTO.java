package com.pda1.information_connector.shinhan.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StrategyDataDTO {

    @JsonProperty("reg_date")
    private String date;

    @JsonProperty("title")
    private String title;

    @JsonProperty("bbs_name")
    private String name;

    @JsonProperty("attachment_url")
    private String url;

}
