package com.pda1.information_connector.scheduler.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AsyncService {

    public CompletableFuture<String> sendAsyncRequests(int numberOfRequests) {
        CompletableFuture<String>[] futures = new CompletableFuture[numberOfRequests];

        for (int i = 0; i < numberOfRequests; i++) {
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                return new RestTemplate().getForObject("http://localhost:5000/api/async/test", String.class);
            });

            futures[i] = future;
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);

        return allOf.thenApply(v -> {
            StringBuilder response = new StringBuilder();
            for (int i = 0; i < numberOfRequests; i++) {
                try {
                    String result = futures[i].get();
                    response.append("Response " + (i + 1) + ": " + result + "\n");
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            return response.toString();
        });
    }
}

