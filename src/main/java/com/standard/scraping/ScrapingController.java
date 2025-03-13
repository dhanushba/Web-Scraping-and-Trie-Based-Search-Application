package com.standard.scraping;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ScrapingController {

    private final WebScrapingService webScrapingService;
    private final TrieService trieService;

    public ScrapingController(WebScrapingService webScrapingService, TrieService trieService) {
        this.webScrapingService = webScrapingService;
        this.trieService = trieService;
    }

    @PostMapping("/scrape")
    public ResponseEntity<?> scrape(@RequestBody ScrapingRequest request) {
        List<String> urls = request.getUrls();
        List<String> keywords = request.getKeywords();
        CompletableFuture<String> scrapedContent = webScrapingService.scrapeContent(urls, keywords);
        return ResponseEntity.ok(new ApiResponse("success", "Scraping initiated", scrapedContent));
    }

    @PostMapping("/search")
    public ResponseEntity<?> search(@RequestBody SearchRequest request) {
        String prefix = request.getPrefix();
        List<String> searchResults = trieService.searchWithDetails(prefix);
        return ResponseEntity.ok(new ApiResponse("success", "Search completed", searchResults));
    }

    @GetMapping("/status/{jobId}")
    public ResponseEntity<?> status(@PathVariable String jobId) {
        return ResponseEntity.ok(new ApiResponse("completed", "Scraping completed successfully"));
    }
}
