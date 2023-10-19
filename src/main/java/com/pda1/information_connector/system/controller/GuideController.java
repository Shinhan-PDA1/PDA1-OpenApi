package com.pda1.information_connector.system.controller;

import com.pda1.information_connector.system.controller.response.ClientDetailResponse;
import com.pda1.information_connector.system.controller.response.GuideResponse;
import com.pda1.information_connector.system.service.DetailService;
import com.pda1.information_connector.system.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/zootopia")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GuideController {

    private final GuideService guideService;

    @GetMapping("/guide")
    public ResponseEntity<?> getGuideInformation(@RequestParam Long userId){

        GuideResponse response = guideService.getGuideInformation(userId);

        return ResponseEntity.ok(response);
    }



}
