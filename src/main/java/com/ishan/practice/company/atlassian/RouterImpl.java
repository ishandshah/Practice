/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.atlassian;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RouterImpl implements Router {

    Map<Pattern, String> routerPath = new HashMap<>();

    public Map<Pattern, String> getRouterPath() {
        return routerPath;
    }

    public void setRouterPath(Map<Pattern, String> routerPath) {
        this.routerPath = routerPath;
    }

    @Override
    public void withRoute(String path, String result) {
        if (routerPath.containsKey(path)) {
            // Not to worry on updates
        }

        String convertedPath;
        Pattern patternInstance;
        if (path.contains("{id}")) {
            convertedPath = convertPathWithId(path);
        } else {
            convertedPath = convertPathToRegex(path);
        }
        patternInstance = Pattern.compile(convertedPath);

        routerPath.put(patternInstance, result);
    }

    private String convertPathWithId(String pathRoute) {
        String[] pathArray = pathRoute.split("\\/");
        StringBuilder sb = new StringBuilder();
        // foo/{}id/bar
        // / - foo id bar
        // foo/{regex}/bar
        for (String path : pathArray) {
            if (path == "") {
                continue;
            }
            sb.append("/");
            if (path.equalsIgnoreCase("{id}")) {
                sb.append("^[0-9a-fA-F]{8}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{12}$");
            } else {
                sb.append(path);
            }
        }
        return sb.toString();
    }

    private String convertPathToRegex(String path) {
        String regex = path.replaceAll("\\*", ".*");
        return "^" + regex + "$";

    }

    @Override
    public String route(String path) {
        for (Map.Entry<Pattern, String> patternStringEntry : routerPath.entrySet()) {
            Pattern pattern = patternStringEntry.getKey();
            Matcher matches = pattern.matcher(path);
            if (matches.find()) {
                return patternStringEntry.getValue();
            }
        }

        return "No route found";

    }

}





