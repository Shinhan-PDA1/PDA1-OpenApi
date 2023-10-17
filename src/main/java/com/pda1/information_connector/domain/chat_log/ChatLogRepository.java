package com.pda1.information_connector.domain.chat_log;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatLogRepository extends JpaRepository<ChatLog, Long> {
    List<ChatLog> findAllByUserId(Long userId);
}
