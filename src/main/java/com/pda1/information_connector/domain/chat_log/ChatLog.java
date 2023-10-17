package com.pda1.information_connector.domain.chat_log;

import com.pda1.information_connector.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ChatLog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @Column
    private Long userId;
    private String requestType;
    private String requestContent;

    @Column(columnDefinition = "LONGTEXT")
    private String requestDescription;
}
