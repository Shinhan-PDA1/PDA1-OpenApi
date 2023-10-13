package com.pda1.information_connector.korea_investment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UriBuilderService {
    private static final String CREATE_TOKEN_URL =  "https://openapi.koreainvestment.com:9443/oauth2/tokenP";
    private static final String CHART_REQUEST_URL =  "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-daily-itemchartprice";

    public URI buildTokenAccessUri(){
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(CREATE_TOKEN_URL);

        URI uri =uriBuilder.build().encode().toUri();

        System.out.println(uri);

        return uri;
    }

    public URI buildChartRequestUri(String code){
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(CHART_REQUEST_URL);

        LocalDate currDate = LocalDate.now();
        LocalDate pastDate = currDate.minusYears(3);
        System.out.println(currDate);
        System.out.println(pastDate);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String currDateStr = currDate.format(dateFormatter);
        String pastDateStr = pastDate.format(dateFormatter);

        uriBuilder.queryParam("FID_COND_MRKT_DIV_CODE", "J");
        uriBuilder.queryParam("FID_INPUT_ISCD", code);
        uriBuilder.queryParam("FID_INPUT_DATE_1", pastDateStr);
        uriBuilder.queryParam("FID_INPUT_DATE_2", currDateStr);
        uriBuilder.queryParam("FID_PERIOD_DIV_CODE", "D");
        uriBuilder.queryParam("FID_ORG_ADJ_PRC", 0);

        URI uri =uriBuilder.build().encode().toUri();

        System.out.println(uri);

        return uri;
    }
    public URI buildSecondChartRequestUri(String code, String date) throws ParseException {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(CHART_REQUEST_URL);

        int pastDate = Integer.parseInt(date) - 10000;

        // 결과를 다시 문자열로 변환
        String pastDateStr = Integer.toString(pastDate);

        uriBuilder.queryParam("FID_COND_MRKT_DIV_CODE", "J");
        uriBuilder.queryParam("FID_INPUT_ISCD", code);
        uriBuilder.queryParam("FID_INPUT_DATE_1", pastDateStr);
        uriBuilder.queryParam("FID_INPUT_DATE_2", date);
        uriBuilder.queryParam("FID_PERIOD_DIV_CODE", "D");
        uriBuilder.queryParam("FID_ORG_ADJ_PRC", 0);

        URI uri =uriBuilder.build().encode().toUri();

        System.out.println(uri);

        return uri;
    }





}
