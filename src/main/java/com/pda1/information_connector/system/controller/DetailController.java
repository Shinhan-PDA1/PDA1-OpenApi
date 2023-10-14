package com.pda1.information_connector.system.controller;

import com.pda1.information_connector.shinhan.controller.response.MainPortfolioResponse;
import com.pda1.information_connector.system.controller.response.MainDetailResponse;
import com.pda1.information_connector.system.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/zootopia")
public class DetailController {

    private final DetailService detailService;

    @GetMapping("/detail")
    public ResponseEntity<?> getDetailInformation(@RequestParam String code) {

        MainDetailResponse resposne = detailService.getDetailInformation(code);

        return ResponseEntity.ok(resposne);
    }

}
