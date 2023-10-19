package com.pda1.information_connector.ksd.controller;

import com.pda1.information_connector.domain.stock_info.StockInformationRepository;
import com.pda1.information_connector.ksd.controller.response.StockInfoResponse;
import com.pda1.information_connector.ksd.service.KSDApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class KSDApiController {

    @Autowired
    private KSDApiService ksdApiService;

    @GetMapping("/api/v1/ksd")
    public ResponseEntity<?> saveKSDData() {
        boolean isSuccess = false;
        try {
            System.out.println("Start");
            isSuccess = ksdApiService.saveKSDStockData();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.ok(isSuccess);
    }
}
