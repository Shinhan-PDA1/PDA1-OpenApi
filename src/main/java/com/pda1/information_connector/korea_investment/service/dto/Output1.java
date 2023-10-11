package com.pda1.information_connector.korea_investment.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Output1 {

    @JsonProperty("prdy_vrss")
    private String prdy_vrss;

    @JsonProperty("prdy_vrss_sign")
    private String prdy_vrss_sign;

    @JsonProperty("prdy_ctrt")
    private String prdy_ctrt;

    @JsonProperty("stck_prdy_clpr")
    private String stck_prdy_clpr;

    @JsonProperty("acml_vol")
    private String acml_vol;

    @JsonProperty("acml_tr_pbmn")
    private String acml_tr_pbmn;

    @JsonProperty("hts_kor_isnm")
    private String hts_kor_isnm;

    @JsonProperty("stck_prpr")
    private String stck_prpr;

    @JsonProperty("stck_shrn_iscd")
    private String stck_shrn_iscd;

    @JsonProperty("prdy_vol")
    private String prdy_vol;

    @JsonProperty("stck_mxpr")
    private String stck_mxpr;

    @JsonProperty("stck_llam")
    private String stck_llam;

    @JsonProperty("stck_oprc")
    private String stck_oprc;

    @JsonProperty("stck_hgpr")
    private String stck_hgpr;

    @JsonProperty("stck_lwpr")
    private String stck_lwpr;

    @JsonProperty("stck_prdy_oprc")
    private String stck_prdy_oprc;

    @JsonProperty("stck_prdy_hgpr")
    private String stck_prdy_hgpr;

}
