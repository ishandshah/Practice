/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.practiceatlassian.ranking;

import java.util.ArrayList;
import java.util.List;

public class ArticleManager {

    private List<Article> articles;
    private RankingSystem rankingSystem;

    public ArticleManager() {
        articles = new ArrayList<>();
        rankingSystem = new RankingSystem();
    }

    public void addArticle(Article article) {
        articles.add(article);
        // Calculate the rank for the newly added article
        int rank = rankingSystem.calculateRank(article, RankingCriteria.FRESHNESS);
        article.setRank(rank);
    }

    public List<Article> getArticlesByRank(RankingCriteria criteria) {
        // Sort the articles based on the specified criteria
        // ...
        // Return the sorted list
        // ...
        return null;
    }

    public Article getArticleById(int id) {
        // Find and return the article with the specified ID
        // ...
        return null;
    }
}
