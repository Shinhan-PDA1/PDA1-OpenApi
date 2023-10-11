package com.pda1.information_connector.korea_investment.controller;

import com.pda1.information_connector.korea_investment.controller.response.ChartResponse;
import com.pda1.information_connector.korea_investment.service.KoreaInvestApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.datatransfer.Clipboard;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stock/information")
public class KoreaInvestStockApiController {

    private final KoreaInvestApiService koreaInvestApiService;

    @GetMapping("/test")
    public ResponseEntity<?> testApi(@RequestParam String code) {
        ChartResponse chartResponse= koreaInvestApiService.getChartData(code);
        return ResponseEntity.ok(chartResponse);
    }

}
