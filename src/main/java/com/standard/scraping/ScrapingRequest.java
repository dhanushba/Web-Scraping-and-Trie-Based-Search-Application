package com.standard.scraping;

import java.util.List;

public class ScrapingRequest {
    private List<String> urls;
    private List<String> keywords;

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
