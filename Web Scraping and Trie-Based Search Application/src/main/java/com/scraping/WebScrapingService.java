package com.standard.scraping;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class WebScrapingService {

    @Async
    @Retryable(value = {IOException.class}, maxAttempts = 5, backoff = @Backoff(delay = 5000))
    public CompletableFuture<String> scrapeContent(List<String> urls, List<String> keywords) {
        StringBuilder scrapedData = new StringBuilder();
        for (String url : urls) {
            try {
                Document doc = Jsoup.connect(url).get();
                String content = doc.body().text();
                if (containsKeywords(content, keywords)) {
                    scrapedData.append(url).append(" : ").append(content).append("\n");
                }
            } catch (IOException e) {
                return CompletableFuture.failedFuture(new ScrapingException("Error scraping URL: " + url));
            }
        }
        return CompletableFuture.completedFuture(scrapedData.toString());
    }

    private boolean containsKeywords(String content, List<String> keywords) {
        return keywords.stream().anyMatch(content::contains);
    }
}
