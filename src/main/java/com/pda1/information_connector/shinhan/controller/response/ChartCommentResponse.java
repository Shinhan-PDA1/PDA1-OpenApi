package com.pda1.information_connector.shinhan.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class ChartCommentResponse {

    private String chart_long_comment;
    private String chart_short_comment;
}
