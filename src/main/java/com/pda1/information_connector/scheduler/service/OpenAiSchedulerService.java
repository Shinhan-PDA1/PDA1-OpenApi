package com.pda1.information_connector.scheduler.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenAiSchedulerService {

    private final AsyncService asyncService;

    @Scheduled(cron = "0 */5 * * * *", zone = "Asia/Seoul")
    public void updateOpenAiComment(){
        System.out.println("@@@@@@ START @@@@@@");
        asyncService.sendAsyncRequests(5);
        // 차트 받아 오는 함수
        System.out.println("@@@@@@ END @@@@@@");

        // 데이터 받아서 open ai 호출해서 답변 받아오는 함수

        // 재무제표 크롤링 해오는 함수

        // 데이터 받아서 open ai 호출해서 답변 받아오는 함수
    }

}
