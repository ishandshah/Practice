/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassianpractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RouterService {
    private Map<Pattern, String> routeMap;
    List<String> servers;
    public RouterService() {
        routeMap = new HashMap<>();
        servers=new ArrayList<>();
    }
    public void addRoute(String pattern, String server) {
        Pattern compiledPattern = Pattern.compile(convertPatternToRegex(pattern));
        routeMap.put(compiledPattern, server);
    }

    private String convertPatternToRegex(String pattern) {
        String regex = pattern.replaceAll("\\*", ".*");
        return "^" + regex + "$";
    }

    public String routeRequest(String input) {
        for (Map.Entry<Pattern, String> entry : routeMap.entrySet()) {
            Pattern pattern = entry.getKey();
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                return entry.getValue();
            }
        }
        return "No matching route found.";
    }

    public static void main(String[] args) {
        RouterService router = new RouterService();
        router.addRoute("/bar/*/ert", "Matched Server 1");
        router.addRoute("/bar/qw/ert", "Matched Server 2");
        router.addRoute("/nordstrom/*/*", "Matched Server 5");

        String input1 = "/bar/qw/ert";
        String result1 = router.routeRequest(input1);
        System.out.println("Input: " + input1 + " --> Result: " + result1);

        String input2 = "/bar/abc/ert";
        String result2 = router.routeRequest(input2);
        System.out.println("Input: " + input2 + " --> Result: " + result2);



        String input12 = "/bar/ishan/ert";
        String result12 = router.routeRequest(input12);
        System.out.println("Input: " + input12 + " --> Result: " + result12);

        String input123 = "/nordstrom/ishan/shah";
        String result123 = router.routeRequest(input123);
        System.out.println("Input: " + input123 + " --> Result: " + result123);
    }
}
