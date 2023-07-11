/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassianpractice.tag;

import java.util.*;
import java.util.stream.Collectors;

public class TaggingServiceImpl implements TagInterface {


    //contentId to tagId
    public static Map<String, Set<String>> contentTagsMap;

    public TaggingServiceImpl() {
        contentTagsMap = new HashMap<>();
    }

    @Override
    public void tagContent(String contentId, String[] tags) {
        Set<String> existingTags = contentTagsMap.getOrDefault(contentId, new HashSet<>());
        existingTags.addAll(Arrays.asList(tags));
        contentTagsMap.put(contentId, existingTags);

    }

    @Override
    public void tagContent(String contentId, Tag[] tags) {
        Set<String> existingTags = contentTagsMap.getOrDefault(contentId, new HashSet<>());

        existingTags.addAll(
                Arrays.stream(tags)
                        .map(Tag::getTagName)
                        .collect(Collectors.toSet())
        );
        contentTagsMap.put(contentId, existingTags);
    }

    @Override
    public List<String> getTagsForContent(String contentId) {
        return new ArrayList<>(contentTagsMap.getOrDefault(contentId, new HashSet<>()));
    }

    @Override
    public List<String> getPopularTags(int limit) {
        Map<String, Integer> tagCountMap = new HashMap<>();
        for (Set<String> tags : contentTagsMap.values()) {
            for (String tag : tags) {
                tagCountMap.put(tag, tagCountMap.getOrDefault(tag, 0) + 1);
            }
        }

        List<String> popularTags = new ArrayList<>(tagCountMap.keySet());
        popularTags.sort((tag1, tag2) -> tagCountMap.get(tag2) - tagCountMap.get(tag1));


        return popularTags.subList(0, Math.min(limit, popularTags.size()));

    }

    @Override
    public List<String> searchContentByTag(String matchedTag) {
        List<String> matchingContentIds = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : contentTagsMap.entrySet()) {
            if (entry.getValue().contains(matchedTag)) {
                matchingContentIds.add(entry.getKey());
            }
        }
        return matchingContentIds;
    }

    @Override
    public void removeTag(String tag) {
        for (Map.Entry<String, Set<String>> entry : contentTagsMap.entrySet()) {
            if (entry.getValue().contains(tag)) {
                entry.getValue().remove(tag);
            }
        }
    }
}
