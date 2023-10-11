package com.pda1.information_connector.korea_investment.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Output2 {

    @JsonProperty("stck_bsop_date")
    private String stck_bsop_date;

    @JsonProperty("stck_clpr")
    private String stck_clpr;

    @JsonProperty("stck_oprc")
    private String stck_oprc;

    @JsonProperty("stck_hgpr")
    private String stck_hgpr;

    @JsonProperty("stck_lwpr")
    private String stck_lwpr;

    @JsonProperty("acml_vol")
    private String acml_vol;

    @JsonProperty("acml_tr_pbmn")
    private String acml_tr_pbmn;

    @JsonProperty("flng_cls_code")
    private String flng_cls_code;

    @JsonProperty("prtt_rate")
    private String prtt_rate;

    @JsonProperty("mod_yn")
    private String mod_yn;

    @JsonProperty("prdy_vrss_sign")
    private String prdy_vrss_sign;

    @JsonProperty("prdy_vrss")
    private String prdy_vrss;
}
