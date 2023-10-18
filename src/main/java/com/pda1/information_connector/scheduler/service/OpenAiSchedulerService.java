package com.pda1.information_connector.scheduler.service;

import com.pda1.information_connector.openai.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenAiSchedulerService {

    private final OpenAiService openAiService;

//    @Scheduled(cron = "0 */5 * * * *", zone = "Asia/Seoul")
//    public void startScheduling(){
//        System.out.println("@@@@@@ START @@@@@@");
//
//        openAiService.updateOpenAiResponse();
//
//        System.out.println("@@@@@@ END @@@@@@");
//    }

}
