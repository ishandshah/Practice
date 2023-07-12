/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.practiceatlassian.scraper;

import java.util.List;

public class ScraperServiceExample {
    public static void main(String[] args) {
        // Create an instance of the scraper service
        ScraperService scraperService = new MyScraperService();
        ScraperService scraperService2 = new ImageScraper();
        // Scrape data from URLs
        scraperService.scrape("http://example.com");
        scraperService.scrape("http://example.org");
        scraperService.scrape("http://example.net");

        // Get the scraped data
        List<String> scrapedData = ((MyScraperService) scraperService).getScrapedData();
        scraperService2.scrape("https://www.google.com");
        // Print the scraped data
        System.out.println("Scraped data:");
        for (String data : scrapedData) {
            System.out.println(data);
        }
    }
}
