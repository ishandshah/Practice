/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.practiceatlassian.loadbalancer;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadBalancer implements LoadBalancerInterface {

    private List<Server> servers;
    private AtomicInteger currentServerIndex;


    public LoadBalancer() {
        servers = new ArrayList<>();
        currentServerIndex = new AtomicInteger(0);
    }

    public static void main(String[] args) {
        LoadBalancer loadBalancer = new LoadBalancer();

        // Add servers with equal weights for Round Robin
        loadBalancer.addServer(new Server("Server1", 1));
        loadBalancer.addServer(new Server("Server2", 1));
        loadBalancer.addServer(new Server("Server3", 1));

        // Perform Round Robin routing
        for (int i = 0; i < 6; i++) {
            Server server = loadBalancer.serveRequest(new Request(i), LoadBalancerType.Round_Robin_Method);
            System.out.println("Round Robin Routing: " + server.getName());
        }

        // Add servers with different weights for Weighted Round Robin
        loadBalancer.addServer(new Server("Server4", 2));
        loadBalancer.addServer(new Server("Server5", 3));

        // Perform Weighted Round Robin routing
        for (int i = 0; i < 9; i++) {
            Server server = loadBalancer.serveRequest((new Request(i)), LoadBalancerType.Weighted_Round_Robin_Method);
            System.out.println("Weighted Round Robin Routing: " + server.getName());
        }


        for (int i = 0; i < 9; i++) {
            Server server = loadBalancer.serveRequest((new Request(i)), LoadBalancerType.IP_Hash);
            System.out.println("IP_Hash Round Robin Routing: " + server.getName());
        }

        for (int i = 0; i < 9; i++) {
            Server server = loadBalancer.serveRequest((new Request(i)), LoadBalancerType.Least_Bandwidth_Method);
            System.out.println("Least_Bandwidth_Method Round Robin Routing: " + server.getName());
        }
    }

    public static Integer calculateMD5(String input) {
        try {
            // Get an instance of the MD5 message digest algorithm
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Convert the input string to bytes using UTF-8 encoding
            byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);

            // Calculate the MD5 hash
            byte[] hashBytes = md.digest(inputBytes);

            // Convert the hash bytes to a BigInteger
            BigInteger hashBigInt = new BigInteger(1, hashBytes);

            // Obtain the integer hash code by taking the absolute value of the BigInteger
            Integer hashCode = Integer.valueOf(hashBigInt.abs().intValue());

            return Math.abs(hashCode);
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception if the MD5 algorithm is not available
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void addServer(Server server) {
        if (!servers.contains(server)) {
            servers.add(server);
        }
    }

    @Override
    public Server getServers(String server) {
        Optional<Server> first = servers.stream().filter(name -> name.getName().equalsIgnoreCase(server)).findFirst();
        return first.isPresent() ? first.get() : null;
    }

    @Override
    public void updateServers(Server server) {
        Optional<Server> first = servers.stream().filter(name -> name.getName().equalsIgnoreCase(server.getName())).findFirst();

        if (first.isPresent()) {
            Server server1 = first.get();
            servers.remove(server1);
            server1 = server;
            servers.add(server1);
        } else {
            servers.add(server);
        }
    }

    @Override
    public Server serveRequest(Request request, LoadBalancerType loadBalancerType) {
        switch (loadBalancerType) {
            case Round_Robin_Method -> {
                return roundRobinDistribution();
            }
            case IP_Hash -> {
                return ipHash(request);
            }
            case Weighted_Round_Robin_Method -> {
                return weightedDistribution();
            }
            default -> {
                return dedault();
            }
        }

    }

    private Server dedault() {

        System.out.println("default is round robin");
        return roundRobinDistribution();
    }

    private Server weightedDistribution() {
        int totalWeight = servers.stream().mapToInt(Server::getWeight).sum();
        int currentIndex = currentServerIndex.getAndIncrement() % totalWeight;
        // 100
        //20

        for (Server server : servers) {
            currentIndex -= server.getWeight();
            if (currentIndex < 0) {
                return server;
            }
        }

        return null;
    }

    private Server ipHash(Request request) {
        Integer s = calculateMD5(String.valueOf(request.requestId));
        int i = s % servers.size();
        return servers.get(i);
    }

    private Server roundRobinDistribution() {
        int index = currentServerIndex.getAndIncrement() % servers.size();
        return servers.get(index);
    }
}
