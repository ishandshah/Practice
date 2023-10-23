/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd.photography;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class PhotographerProfile {
    String name;
    String locationCity;
    List<String> eventTypes;

    int rate;

    double rating;
    List<UUID> userReviews;

    public PhotographerProfile(String memorableMoment, String sanJose, List<String> wedding, int i) {
        this.name = memorableMoment;
        this.locationCity = sanJose;
        this.eventTypes = wedding;
        this.rate = i;
        this.userReviews = new ArrayList<>();
    }

    public void addUserRating(UserRating u1) {
        double aggregated = (rating * userReviews.size()) + Double.valueOf(u1.rating.getValue());
        userReviews.add(u1.id);
        rating = aggregated / userReviews.size();
    }
}
