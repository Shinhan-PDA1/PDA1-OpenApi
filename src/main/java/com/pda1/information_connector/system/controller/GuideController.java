package com.pda1.information_connector.system.controller;

import com.pda1.information_connector.system.controller.response.ClientDetailResponse;
import com.pda1.information_connector.system.controller.response.GuideResponse;
import com.pda1.information_connector.system.service.DetailService;
import com.pda1.information_connector.system.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/zootopia")
public class GuideController {

    private final GuideService guideService;

    @GetMapping("/guide")
    public ResponseEntity<?> getGuideInformation(@RequestParam Long userId){

        GuideResponse response = guideService.getGuideInformation(userId);

        return ResponseEntity.ok(response);
    }



}
