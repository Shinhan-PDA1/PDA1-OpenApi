package com.pda1.information_connector.ksd.service;

import com.pda1.information_connector.ksd.controller.response.StockInfoResponse;
import com.pda1.information_connector.shinhan.controller.response.StrategyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

@Service
@RequiredArgsConstructor
public class KSDUriRequestService {

    public final KSDUriBuilderService uriBuilderService;

    public StockInfoResponse getKospiStockInfo() throws UnsupportedEncodingException, URISyntaxException {
        URI uri = uriBuilderService.buildStockInfoUri();
        String decodedServiceKey = "2ATBby+K2mX2TPS+5RBRQIZ7Np8X7MQ7oTg8uXbQL2WX2SXvZoRXCr9nxc1uHTmpDBNpTGkCWxN2IV9S+bDZPQ==";
        String encodedServiceKey = URLEncoder.encode(decodedServiceKey, "UTF-8");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=UTF-8");
        headers.set("Accept", "*/*;q=0.9");

        HttpEntity httpEntity = new HttpEntity<>(headers);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUri(uri)
                .queryParam("serviceKey", encodedServiceKey)
                .queryParam("numOfRows",20000)
                .queryParam("pageNo", 1)
                .queryParam("resultType", "json");

        URI finalUri = uriBuilder.build().toUri();
        URI myUri = new URI("https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo?serviceKey=2ATBby%2BK2mX2TPS%2B5RBRQIZ7Np8X7MQ7oTg8uXbQL2WX2SXvZoRXCr9nxc1uHTmpDBNpTGkCWxN2IV9S%2BbDZPQ%3D%3D&numOfRows=20000&pageNo=1&resultType=json&basDt=20231013");
        System.out.println("url: "+ myUri);
        System.out.println("Before");

        ResponseEntity<StockInfoResponse> responseEntity = new RestTemplate().exchange(myUri, HttpMethod.GET, httpEntity, StockInfoResponse.class);
        System.out.println("After");

        return responseEntity.getBody();
    }
}
