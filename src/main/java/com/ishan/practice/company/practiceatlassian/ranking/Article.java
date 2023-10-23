/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.practiceatlassian.ranking;

import java.util.Date;
import java.util.Objects;

public class Article {

    private int id;
    private String title;
    private String content;
    private Date updatedTimestamp;
    private int likes;
    private int comments;
    private int shares;

    private int totalScore;
    private int rank;

    public Article(int id, String title, String content, Date updatedTimestamp, int likes, int comments, int shares) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.updatedTimestamp = updatedTimestamp;
        this.likes = likes;
        this.comments = comments;
        this.shares = shares;
        this.totalScore = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Date updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes += likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments += comments;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares += shares;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id && title.equals(article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank += rank;
    }
}
