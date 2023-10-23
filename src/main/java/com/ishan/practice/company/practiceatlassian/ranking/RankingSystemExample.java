/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.practiceatlassian.ranking;

import java.util.Date;
import java.util.List;

public class RankingSystemExample {

    public static void main(String[] args) {
        // Create an instance of ArticleManager
        ArticleManager articleManager = new ArticleManager();

        // Create some articles
        Article article1 = new Article(1, "Title 1", "Content 1", new Date(), 10, 5, 2);
        Article article2 = new Article(2, "Title 2", "Content 2", new Date(), 15, 3, 4);
        Article article3 = new Article(3, "Title 3", "Content 3", new Date(), 8, 7, 1);

        // Add the articles to the ArticleManager
        articleManager.addArticle(article1);
        articleManager.addArticle(article2);
        articleManager.addArticle(article3);

        // Retrieve an article by ID
        Article retrievedArticle = articleManager.getArticleById(2);
        System.out.println("Retrieved Article: " + retrievedArticle.getTitle());

        // Get a list of articles sorted by rank based on a specific criteria
        RankingCriteria criteria = RankingCriteria.LIKES;
        List<Article> rankedArticles = articleManager.getArticlesByRank(criteria);

        System.out.println("Articles sorted by " + criteria + ":");
        for (Article article : rankedArticles) {
            System.out.println(article.getTitle() + " - Rank: " + article.getRank());
        }
    }
}
