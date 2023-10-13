package com.pda1.information_connector.shinhan.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class ShinhanUriBuilderService {
    private static final String PORTFOLIO_RECOMMEND_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/recommend/portfolio";
    private static final String POPULAR_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/ranking/rising";
    private static final String ISSUE_URL =  "https://gapi.shinhaninvest.com:8443/openapi/v1.0/ranking/issue";


    public URI buildRecommendPortfolioUri() {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(PORTFOLIO_RECOMMEND_URL);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }
    public URI buildPopularUri() {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(POPULAR_URL);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }

    public URI buildIssueUri(String query) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(POPULAR_URL);
        uriBuilder.queryParam("query_type", query);


        URI uri =uriBuilder.build().encode().toUri();

        return uri;

    }
}
