package com.pda1.information_connector.korea_investment.controller;

import com.pda1.information_connector.korea_investment.controller.response.ChartResponse;
import com.pda1.information_connector.korea_investment.controller.response.MainChartResponse;
import com.pda1.information_connector.korea_investment.service.KoreaInvestApiService;
import com.pda1.information_connector.korea_investment.service.dto.Output2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.datatransfer.Clipboard;
import java.text.ParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stock/information")
public class KoreaInvestStockApiController {

    private final KoreaInvestApiService koreaInvestApiService;

    @GetMapping("/test")
    public ResponseEntity<?> testApi(@RequestParam String code) throws ParseException {
        MainChartResponse response= koreaInvestApiService.getChartData(code);
        return ResponseEntity.ok(response);
    }

}
