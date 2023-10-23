/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd.photography;

import java.util.*;
import java.util.stream.Collectors;

/*
As part of a user’s search preference, include the date and duration of their event
As part of a user’s search preference, include the maximum cost they will pay
Implement a distance function based on city, state, and zip code


 */
public class Lookup {
    static Map<String, PhotographerProfile> photographerProfileMap = new HashMap<>();

    public static void main(String[] args) {

        //add Photographer

        PhotographerProfile p1 = new PhotographerProfile("Beautiful weddings", "San Jose", List.of("Wedding"), 150);
        addProfile(p1);
        PhotographerProfile p2 = new PhotographerProfile("Memorable Moment", "San Jose", List.of("Wedding"), 250);
        addProfile(p2);
        String eventType = "Wedding";
        String location = "San Jose";

        findPhotographer(eventType, location);


        UserRating u1 = new UserRating(UUID.randomUUID(), "ishan", p1, Rating.TWO, "ok");
        UserRating u2 = new UserRating(UUID.randomUUID(), "ishan", p2, Rating.TWO, "ok");
        UserRating u3 = new UserRating(UUID.randomUUID(), "ishan sah", p2, Rating.THREE, "ok");

        p1.addUserRating(u1);
        p2.addUserRating(u2);
        p2.addUserRating(u3);

        System.out.println(p1.getRating());
        System.out.println(p2.getRating());

        List<PhotographerProfile> photographerProfiles = rankByRating(photographerProfileMap.values());
        photographerProfiles.stream().forEach(System.out::println);

    }

    private static List<PhotographerProfile> rankByRating(Collection<PhotographerProfile> values) {
        return values.stream().sorted(Comparator.comparing(PhotographerProfile::getRating).reversed()).collect(Collectors.toList());
    }

    private static void addProfile(PhotographerProfile p2) {
        photographerProfileMap.put(p2.name, p2);
    }

    private static void findPhotographer(String eventType, String location) {
        //

    }
}
