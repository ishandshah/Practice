/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassianpractice;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {

    List<String> servers;
    int currentIndex;

    public LoadBalancer() {
        this.servers = new ArrayList<>();
        this.currentIndex = 0;
    }

    public static void main(String[] args) {
        {
            LoadBalancer loadBalancer = new LoadBalancer();
            loadBalancer.addServer("Server1");
            loadBalancer.addServer("Server2");
            loadBalancer.addServer("Server3");

            for (int i = 0; i < 10; i++) {
                String server = loadBalancer.getNextServer();
                System.out.println("Request " + (i + 1) + " directed to " + server);
            }
        }
    }

    public void addServer(String server) {
        servers.add(server);
    }

    public String getNextServer() {
        if (servers.isEmpty()) {
            throw new IllegalStateException("No servers available.");
        }

        String server = servers.get(currentIndex);
        currentIndex = (currentIndex + 1) % servers.size();
        return server;
    }
}
