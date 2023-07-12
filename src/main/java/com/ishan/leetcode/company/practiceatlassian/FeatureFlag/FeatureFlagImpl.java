/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.practiceatlassian.FeatureFlag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

public class FeatureFlagImpl implements FeatureFlagInterface {

    Map<String, FeatureFlag> stringFeatureFlagMap = new HashMap<>();

    @Override
    public void addFeatureFlag(FeatureFlag ff) {
        stringFeatureFlagMap.putIfAbsent(ff.name, ff);
    }

    @Override
    public boolean removeFeatureFlag(String ff) {

        FeatureFlag remove = stringFeatureFlagMap.remove(ff);
        return remove.name.equalsIgnoreCase(ff);
    }

    @Override
    public void updateFeatureFlag(FeatureFlag ff) {
        if (stringFeatureFlagMap.containsKey(ff.name)) {
            stringFeatureFlagMap.put(ff.name, ff);
            return;
        }
        // Add logging to update that no flag existed before
        stringFeatureFlagMap.put(ff.name, ff);
    }

    @Override
    public FeatureFlag getFeatureFlag(String name) {
        return stringFeatureFlagMap.get(name);
    }

    @Override
    public List<FeatureFlag> getAllFlags() {
        return stringFeatureFlagMap.
                entrySet().
                stream().
                map(Map.Entry::getValue).
                collect(Collectors.toList());
    }

    @Override
    public List<FeatureFlag> getActiveFlags() {

        List<FeatureFlag> collect = stringFeatureFlagMap.
                entrySet().
                stream().
                filter(x -> x.getValue().isActive == Boolean.TRUE).
                filter(x -> (x.getValue().endTime > System.currentTimeMillis()) && (x.getValue().startTime < System.currentTimeMillis()))
                .map(Map.Entry::getValue).
                collect(Collectors.toList());

        return collect;
    }

    @Override
    public List<FeatureFlag> getInActiveFlags() {
        List<FeatureFlag> collect = stringFeatureFlagMap.
                entrySet().
                stream().
                filter(x -> x.getValue().isActive == Boolean.FALSE).
                filter(x -> (x.getValue().endTime < System.currentTimeMillis()) && (x.getValue().startTime > System.currentTimeMillis()))
                .map(Map.Entry::getValue).
                collect(Collectors.toList());
    return collect;
    }


    public List<FeatureFlag> getFlagsbByEnv(Environment environment) {
        List<FeatureFlag> collect = stringFeatureFlagMap.
                entrySet().
                stream().
                filter(x -> Arrays.stream(x.getValue().supportedEnvironments).
                        anyMatch(y -> y.name().equalsIgnoreCase(environment.name())))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return collect;
    }



    public static void main(String[] args) {
        FeatureFlag ff1 = new FeatureFlag(1, "ishan", Boolean.TRUE, "name", new Environment[]{Environment.DEV, Environment.TEST},
                System.currentTimeMillis(), System.currentTimeMillis() + 10000000);


        FeatureFlag ff2 = new FeatureFlag(1, "ishan shah", Boolean.TRUE, "name with last name", new Environment[]{Environment.PROD, Environment.PREPROD},
                System.currentTimeMillis(), System.currentTimeMillis() + 1);
        FeatureFlagImpl featureFlag = new FeatureFlagImpl();
        featureFlag.addFeatureFlag(ff1);
        featureFlag.addFeatureFlag(ff2);

        ff2.description="su che";

        featureFlag.updateFeatureFlag(ff2);

        System.out.println("Active" + featureFlag.getActiveFlags());

        System.out.println("ALL" + featureFlag.getAllFlags());

        System.out.println("InActive" + featureFlag.getInActiveFlags());

        System.out.println("BY ENV" + featureFlag.getFlagsbByEnv(Environment.PROD));

    }
}
