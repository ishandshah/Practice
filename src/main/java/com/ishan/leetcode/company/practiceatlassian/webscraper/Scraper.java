/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.practiceatlassian.webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class Scraper {

    private static Set<String> visitedUrls = new HashSet<>();

    public static void main(String[] args) {
        String[] urls = {"https://www.google.com"};
        for (String url : urls) {
            scrapeImages(url);
        }
    }

    private static void scrapeImages(String url) {
        try {
            if (!visitedUrls.contains(url)) {
                visitedUrls.add(url);
                System.out.println("Scraping images from: " + url);

                Document doc = Jsoup.connect(url).get();

                // Extract image links from the current page
                Elements imgElements = doc.select("img[src]");
                for (Element imgElement : imgElements) {
                    String imgUrl = imgElement.absUrl("src");
                    saveImage(imgUrl);
                }

                // Follow other links on the page and recursively scrape images
                Elements linkElements = doc.select("a[href]");
                for (Element linkElement : linkElements) {
                    String linkUrl = linkElement.absUrl("href");
                    scrapeImages(linkUrl);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveImage(String imageUrl) {
        try (InputStream in = new BufferedInputStream(new URL(imageUrl).openStream());
             FileOutputStream out = new FileOutputStream(getFileName(imageUrl))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            System.out.println("Saved image: " + imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileName(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }
}
