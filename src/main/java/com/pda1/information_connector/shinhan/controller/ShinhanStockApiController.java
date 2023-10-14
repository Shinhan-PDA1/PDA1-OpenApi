package com.pda1.information_connector.shinhan.controller;

import com.pda1.information_connector.korea_investment.controller.response.MainChartResponse;
import com.pda1.information_connector.shinhan.controller.response.*;
import com.pda1.information_connector.shinhan.service.ShinhanApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shinhan")
public class ShinhanStockApiController {

    private final ShinhanApiService shinhanApiService;

    @GetMapping("/recommend/portfolio")
    public ResponseEntity<?> recommendFortfolio() {
        List<MainPortfolioResponse> response= shinhanApiService.getPortfolio();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/ranking/rising")
    public ResponseEntity<?> rankingRising() {
        List<MainPopularResponse> response= shinhanApiService.getPopular();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/ranking/issue")
    public ResponseEntity<?> rankingIssue(@RequestParam(name = "query_type") String queryType) {
        List<MainIssueResponse> response= shinhanApiService.getIssue(queryType);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/strategy/invest")
    public ResponseEntity<?> strategyInvest() {
        List<MainStrategyResponse> response= shinhanApiService.getStrategy();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/strategy/market-issue")
    public ResponseEntity<?> marketIssue() {
        List<MainMarketResponse> response= shinhanApiService.getMarketIssue();
        return ResponseEntity.ok(response);
    }
}
