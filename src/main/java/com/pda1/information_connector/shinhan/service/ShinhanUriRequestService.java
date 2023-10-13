package com.pda1.information_connector.shinhan.service;


import com.pda1.information_connector.shinhan.controller.response.PortfolioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class ShinhanUriRequestService {

    public final ShinhanUriBuilderService uriBuilderService;

    public PortfolioResponse getPortfolio() {

        URI uri = uriBuilderService.buildRecommendPortfolioUri();

        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apiKey", "l7xxR7Fe0dP3i8KPZaPKpknI2vWrMeJfwDpk");

        HttpEntity httpEntity = new HttpEntity<>(headers);

        return new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, PortfolioResponse.class).getBody();
    }
}
