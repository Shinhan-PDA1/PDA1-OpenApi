package com.pda1.information_connector.system.service;

import com.pda1.information_connector.domain.chat_log.ChatLog;
import com.pda1.information_connector.domain.chat_log.ChatLogRepository;

import com.pda1.information_connector.system.controller.response.GuideResponse;
import com.pda1.information_connector.system.service.dto.GuideDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuideService {

    private final ChatLogRepository chatLogRepository;
    public GuideResponse getGuideInformation(Long userId) {

        GuideResponse response = new GuideResponse();

        List<ChatLog> chatLogList = chatLogRepository.findAllByUserId(userId);

        chatLogList.stream().forEach(
                log -> response.getResponse().add(
                        GuideDTO.builder()
                                .type(log.getRequestType())
                                .question(log.getRequestContent())
                                .description(log.getRequestDescription())
                                .build()));

        return response;
    }
}
