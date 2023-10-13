package com.pda1.information_connector.shinhan.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class ShinhanUriBuilderService {
    private static final String PORTFOLIO_RECOMMEND_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/recommend/portfolio";


    public URI buildRecommendPortfolioUri() {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(PORTFOLIO_RECOMMEND_URL);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }
}
