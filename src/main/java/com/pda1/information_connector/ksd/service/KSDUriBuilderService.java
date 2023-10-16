package com.pda1.information_connector.mysql.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class KSDUriBuilderService {
    private static final String STOCK_INFORMATION_URL="https://api.seibro.or.kr/openapi/service/StockSvc/getShotnByMartN1";

    public URI buildStockInfoUri() {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(STOCK_INFORMATION_URL);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }
}
