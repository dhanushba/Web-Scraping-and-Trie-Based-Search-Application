package com.standard.scraping;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class WebScrapingServiceTest {

    private WebScrapingService webScrapingService;

    @BeforeEach
    void setUp() {
        webScrapingService = new WebScrapingService();
    }

    @Test
    void testScrapeContent() {
        List<String> urls = List.of("http://standard.com");
        List<String> keywords = List.of("technology");
        CompletableFuture<String> result = webScrapingService.scrapeContent(urls, keywords);

        assertNotNull(result);
        result.thenAccept(content -> {
            assertTrue(content.contains("technology"));
        });
    }
}
