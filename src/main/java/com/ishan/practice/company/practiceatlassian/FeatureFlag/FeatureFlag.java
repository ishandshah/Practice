/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.practiceatlassian.FeatureFlag;

import java.util.Arrays;

//TODO add some UNIT TESTS
public class FeatureFlag {

    int id;
    String name;

    boolean isActive;

    String description;

    Environment[] supportedEnvironments;

    Long startTime;
    Long endTime;

    public FeatureFlag(int id, String name, boolean isActive, String description, Environment[] supportedEnvironments, Long startTime, Long endTime) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.description = description;
        this.supportedEnvironments = supportedEnvironments;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "FeatureFlag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", description='" + description + '\'' +
                ", supportedEnvironments=" + Arrays.toString(supportedEnvironments) +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
