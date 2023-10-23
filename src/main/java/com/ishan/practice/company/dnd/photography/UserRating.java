/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd.photography;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

enum Rating {
    NONE(0), ONE(1), TWO(2), THREE(3);

    private final int value;

    private Rating(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

@Data
@AllArgsConstructor
public class UserRating {
    UUID id;

    String customerName;
    PhotographerProfile photographerProfile;

    Rating rating;

    String comment;


}