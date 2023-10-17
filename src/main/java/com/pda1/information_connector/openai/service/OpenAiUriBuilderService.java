package com.pda1.information_connector.openai.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class OpenAiUriBuilderService {

    private static final String WORD_EXPLAIN_URL = "http://localhost:5000/api/v1/openai/word";
    private static final String QUESTION_EXPLAIN_URL = "http://localhost:5000/api/v1/openai/question";
    private static final String DATA_ANALYSE_URL = "http://localhost:5000/api/v1/openai/analysis";

    public URI buildQuestionUri() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(QUESTION_EXPLAIN_URL);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }
    public URI buildWordUri() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(WORD_EXPLAIN_URL);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }

    public URI buildDataAnalyseUri() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(DATA_ANALYSE_URL);

        URI uri =uriBuilder.build().encode().toUri();

        return uri;
    }
}
