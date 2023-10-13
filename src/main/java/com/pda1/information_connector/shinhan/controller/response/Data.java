package com.pda1.information_connector.shinhan.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Data {

    @JsonProperty("stock_code")
    private String stock_code;

    @JsonProperty("reve_rt")
    private String reve_rt;

    @JsonProperty("stbd_name")
    private String stbd_name;

    @JsonProperty("incp_ymd")
    private String incp_ymd;

    @JsonProperty("incp_prc")
    private String incp_prc;

}
