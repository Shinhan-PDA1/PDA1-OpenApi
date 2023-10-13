package com.pda1.information_connector.korea_investment.service;

import com.pda1.information_connector.korea_investment.controller.response.ChartResponse;
import com.pda1.information_connector.korea_investment.controller.response.TokenAccessResponse;
import com.pda1.information_connector.korea_investment.service.dto.Output2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.ParseException;

@Service
@RequiredArgsConstructor
public class UriRequestService {

    public final UriBuilderService uriBuilderService;

    public TokenAccessResponse requestToken(){

        URI uri = uriBuilderService.buildTokenAccessUri();

        String jsonRequest = "{" +
                "\"grant_type\": \"client_credentials\"," +
                "\"appkey\": \"PS87eJIArQfZ0IWKXJgSwbXLYfFGiMQtAzsu\"," +
                "\"appsecret\": \"l3PXUKbMRnMVHYxHo5LG6mZo6l6LcINLU2qdZ2IsnGVkcbgqy/SRW63gATuoext7Z84foELuL22VYncgJIX1KIgj9d9c6efW2s0lkoI6uZcRRYRzwZ+uyL3WbbL3p2Ji9lCGmMFkmlrOdX0PCdhzsL9sVcUlAglUHNRFLJPipBYOtSR39fo=\"" +
                "}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>(jsonRequest, headers);

        return new RestTemplate().exchange(uri, HttpMethod.POST, httpEntity, TokenAccessResponse.class).getBody();
    }

    public ChartResponse getChartData(String code, String token) {

        URI uri = uriBuilderService.buildChartRequestUri(code);

        String accessToken = "Bearer " + token;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Authorization, appkey, appsecret, tr_id 등의 헤더 정보 추가
        headers.set("Authorization", accessToken);
        headers.set("appkey", "PS87eJIArQfZ0IWKXJgSwbXLYfFGiMQtAzsu");
        headers.set("appsecret", "l3PXUKbMRnMVHYxHo5LG6mZo6l6LcINLU2qdZ2IsnGVkcbgqy/SRW63gATuoext7Z84foELuL22VYncgJIX1KIgj9d9c6efW2s0lkoI6uZcRRYRzwZ+uyL3WbbL3p2Ji9lCGmMFkmlrOdX0PCdhzsL9sVcUlAglUHNRFLJPipBYOtSR39fo=");
        headers.set("tr_id", "FHKST03010100");

        HttpEntity httpEntity = new HttpEntity<>(headers);

        return new RestTemplate().exchange(uri, HttpMethod.POST, httpEntity, ChartResponse.class).getBody();
    }
    public ChartResponse getSecondChartData(String code, String token, String date) throws ParseException {

        URI uri = uriBuilderService.buildSecondChartRequestUri(code,date);

        String accessToken = "Bearer " + token;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Authorization, appkey, appsecret, tr_id 등의 헤더 정보 추가
        headers.set("Authorization", accessToken);
        headers.set("appkey", "PS87eJIArQfZ0IWKXJgSwbXLYfFGiMQtAzsu");
        headers.set("appsecret", "l3PXUKbMRnMVHYxHo5LG6mZo6l6LcINLU2qdZ2IsnGVkcbgqy/SRW63gATuoext7Z84foELuL22VYncgJIX1KIgj9d9c6efW2s0lkoI6uZcRRYRzwZ+uyL3WbbL3p2Ji9lCGmMFkmlrOdX0PCdhzsL9sVcUlAglUHNRFLJPipBYOtSR39fo=");
        headers.set("tr_id", "FHKST03010100");

        HttpEntity httpEntity = new HttpEntity<>(headers);

        return new RestTemplate().exchange(uri, HttpMethod.POST, httpEntity, ChartResponse.class).getBody();
    }
}
