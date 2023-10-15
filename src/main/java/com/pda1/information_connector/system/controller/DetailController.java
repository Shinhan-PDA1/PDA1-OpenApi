package com.pda1.information_connector.system.controller;

import com.pda1.information_connector.system.controller.response.ClientChartResponse;
import com.pda1.information_connector.system.controller.response.ClientStatementResponse;
import com.pda1.information_connector.system.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/zootopia")
public class DetailController {

    private final DetailService detailService;

    @GetMapping("/detail/chart")
    public ResponseEntity<?> getChartInformation(@RequestParam String code) throws ParseException {

        ClientChartResponse resposne = detailService.getChartInformation(code);

        return ResponseEntity.ok(resposne);
    }

    @GetMapping("/detail/statements")
    public ResponseEntity<?> getStatementInformation(@RequestParam String code) {

        ClientStatementResponse resposne = detailService.getStatementInformation(code);

        return ResponseEntity.ok(resposne);
    }

}
