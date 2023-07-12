/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.practiceatlassian.loadbalancer;

import java.util.Objects;

public class Server {
    private String name;
    private int weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Server server = (Server) o;
        return name.equals(server.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private int activeConnections;

    private int averageResponseTime;


    private int bandwidthCurrentlyServed;

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getActiveConnections() {
        return activeConnections;
    }

    public void setActiveConnections(int activeConnections) {
        this.activeConnections = activeConnections;
    }

    public int getAverageResponseTime() {
        return averageResponseTime;
    }

    public void setAverageResponseTime(int averageResponseTime) {
        this.averageResponseTime = averageResponseTime;
    }

    public int getBandwidthCurrentlyServed() {
        return bandwidthCurrentlyServed;
    }

    public void setBandwidthCurrentlyServed(int bandwidthCurrentlyServed) {
        this.bandwidthCurrentlyServed = bandwidthCurrentlyServed;
    }

    public Server(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.activeConnections=0;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
