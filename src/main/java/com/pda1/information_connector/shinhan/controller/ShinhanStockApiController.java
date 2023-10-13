package com.pda1.information_connector.shinhan.controller;

import com.pda1.information_connector.korea_investment.controller.response.MainChartResponse;
import com.pda1.information_connector.shinhan.controller.response.MainPortfolioResponse;
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
}
