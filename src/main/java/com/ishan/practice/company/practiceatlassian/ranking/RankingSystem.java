/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.practiceatlassian.ranking;

/* High level code design of ranking system for confluence system where ranking is based on the freshness, likes, comments and shares.
 */

public class RankingSystem {

    public int calculateRank(Article article, RankingCriteria criteria) {
        switch (criteria) {
            case FRESHNESS:
                return calculateFreshnessRank(article);
            case LIKES:
                return calculateLikesRank(article);
            case COMMENTS:
                return calculateCommentsRank(article);
            case SHARES:
                return calculateSharesRank(article);
            default:
                throw new IllegalArgumentException("Unsupported ranking criteria: " + criteria);
        }
    }

    private int calculateSharesRank(Article article) {
        article.setShares(1);
        return article.getRank() + 3;
    }


    private int calculateCommentsRank(Article article) {
        article.setComments(1);
        return article.getRank() + 2;
    }

    private int calculateLikesRank(Article article) {
        article.setLikes(1);
        return article.getRank() + 1;
    }

    private int calculateFreshnessRank(Article article) {
        //calculate based on time
        return article.getRank() + 4;
    }
}
