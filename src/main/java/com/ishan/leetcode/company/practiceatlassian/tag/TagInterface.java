/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.practiceatlassian.tag;

import java.util.List;

public interface TagInterface {


    void tagContent(String contentId, String[] tags);

    List<String> getTagsForContent(String contentId);

    List<String> getPopularTags(int limit);

    List<String> searchContentByTag(String tag);


    public void removeTag(String tag);

    void tagContent(String contentId, Tag[] tags);
}
