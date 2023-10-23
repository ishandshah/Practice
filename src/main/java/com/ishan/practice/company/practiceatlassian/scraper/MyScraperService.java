/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.practiceatlassian.scraper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyScraperService implements ScraperService {
    Set<String> visitedURLS;
    private List<String> scrapedData;

    public MyScraperService() {
        scrapedData = new ArrayList<>();
        visitedURLS = new HashSet<>();
    }

    @Override
    public void scrape(String url) {
        if (visitedURLS.contains(url)) {
            return;
        }
        //add logic


        scrapedData.add("Scraped data from " + url);
    }

    public List<String> getScrapedData() {
        return scrapedData;
    }
}
