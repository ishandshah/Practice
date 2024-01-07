/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.hundreddays.October.oct17;

import java.util.*;


// this works but runtime beats just 13%
public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        Map<Point, Double> doublePointMap = new HashMap<>();
        for (int[] point : points) {
            doublePointMap.put(new Point(point[0], point[1]), calculate(point[0], point[1]));
        }

        // Convert the map to a list of entries
        List<Map.Entry<Point, Double>> entryList = new ArrayList<>(doublePointMap.entrySet());

        // Sort the list by values
        Collections.sort(entryList, Map.Entry.comparingByValue());

        // Create a LinkedHashMap to store the sorted entries
        Map<Point, Double> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Point, Double> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Print the sorted map
        for (Map.Entry<Point, Double> entry : sortedMap.entrySet()) {
            if (k > 0) {
                //  int position=--k;
                result[--k][0] = entry.getKey().x1;
                result[k][1] = entry.getKey().y1;
            } else {
                break;
            }
        }
        return result;
    }

    private Double calculate(int i, int j) {
        return Math.sqrt((i * i) + (j * j));
    }

    public int[][] kClosestQueue(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(dist(a), dist(b)));
        for (int[] p : points) {
            pq.add(p);
        }
        int[][] res = new int[k][2];
        while (!pq.isEmpty() && k > 0) {
            res[--k] = pq.remove();
        }
        return res;
    }

    private int dist(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }

    class Point {
        int x1;
        int y1;

        public Point(int x1, int y1) {
            this.x1 = x1;
            this.y1 = y1;
        }

        public int getX1() {
            return x1;
        }

        public void setX1(int x1) {
            this.x1 = x1;
        }

        public int getY1() {
            return y1;
        }

        public void setY1(int y1) {
            this.y1 = y1;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1);
        }
    }


}
