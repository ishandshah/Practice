/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.practiceatlassian.FeatureFlag;

import java.util.List;

public interface FeatureFlagInterface {

    void addFeatureFlag(FeatureFlag ff);

    boolean removeFeatureFlag(String ff);

    void updateFeatureFlag(FeatureFlag ff);

    FeatureFlag getFeatureFlag(String name);

    List<FeatureFlag> getAllFlags();

    List<FeatureFlag> getActiveFlags();

    List<FeatureFlag> getInActiveFlags();

}
