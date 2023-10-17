package com.pda1.information_connector.scheduler.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class OpenAiSchedulerService {



    @Scheduled(cron = "0 * * * * *", zone = "Asia/Seoul")
    public void updateOpenAiComment(){
        System.out.println("@@@@@@");

        // 차트 받아 오는 함수

        // 데이터 받아서 open ai 호출해서 답변 받아오는 함수

        // 재무제표 크롤링 해오는 함수

        // 데이터 받아서 open ai 호출해서 답변 받아오는 함수
    }

}
