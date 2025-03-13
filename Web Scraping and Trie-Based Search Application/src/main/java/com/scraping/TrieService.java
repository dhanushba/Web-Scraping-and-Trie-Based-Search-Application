package com.standard.scraping;

import java.util.*;

@Service
public class TrieService {

    private final TrieNode root = new TrieNode();

    public void insert(String word, String url, String timestamp) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.isEndOfWord = true;
        node.urls.add(url);
        node.timestamps.add(timestamp);
    }

    public List<String> searchWithDetails(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return new ArrayList<>();
            }
        }
        return collectDetailedWords(node, prefix);
    }

    private List<String> collectDetailedWords(TrieNode node, String prefix) {
        List<String> results = new ArrayList<>();
        if (node.isEndOfWord) {
            results.add(prefix + " matched in URLs: " + node.urls + " at timestamps: " + node.timestamps);
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            results.addAll(collectDetailedWords(entry.getValue(), prefix + entry.getKey()));
        }
        return results;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
    List<String> urls = new ArrayList<>();
    List<String> timestamps = new ArrayList<>();
}
