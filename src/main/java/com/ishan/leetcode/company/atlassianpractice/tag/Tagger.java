/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassianpractice.tag;

public class Tagger{

    public static void main(String[] args) {
        TaggingServiceImpl tmp=new TaggingServiceImpl();
        String[] tags={"ishan","shah","jsk", "fam"};
        tmp.tagContent("ishan",tags);
        System.out.println(TaggingServiceImpl.contentTagsMap.entrySet());

        System.out.println(tmp.getPopularTags(2));

        System.out.println(tmp.getTagsForContent("ishan"));

        System.out.println(tmp.searchContentByTag("ishan"));

        tmp.removeTag("ishan");
        System.out.println(TaggingServiceImpl.contentTagsMap.entrySet());


        Tag t1=new Tag(1,"john", "john");
        Tag t2=new Tag(2,"john cena", "john");
        Tag t3=new Tag(3,"john abraham", "john");


        Tag[] tagArray={t1,t2,t3};
        tmp.tagContent("ishan shah",tagArray);
        System.out.println(TaggingServiceImpl.contentTagsMap.entrySet());
    }
}
