package com.pda1.information_connector.system.controller;

import com.pda1.information_connector.system.controller.response.ClientChartResponse;
import com.pda1.information_connector.system.controller.response.ClientDetailResponse;
import com.pda1.information_connector.system.controller.response.ClientStatementResponse;
import com.pda1.information_connector.system.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/zootopia")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DetailController {

    private final DetailService detailService;

    @GetMapping("/detail")
    public ResponseEntity<?> getChartInformation(@RequestParam String code) throws Throwable {

        ClientDetailResponse response = detailService.getDetailInformation(code);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/search")
    public ResponseEntity<?> getStockCode(@RequestParam String stockName) {

        String code = detailService.getStockCode(stockName);

        return ResponseEntity.ok(code);
    }



}
