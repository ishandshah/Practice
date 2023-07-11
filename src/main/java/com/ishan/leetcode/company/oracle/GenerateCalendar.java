/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateCalendar {
    public static void main(String[] args) {
        List<Interviewer> interviewers = new ArrayList<>();


        List<Integer> modifiableList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> modifiableList2 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        modifiableList2.removeIf(n -> n == 4|| n==5);
        List<Integer> modifiableList3 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        modifiableList3.removeIf(n -> n == 1|| n==2);
        interviewers.add(new Interviewer("John", modifiableList));
        interviewers.add(new Interviewer("Alice",modifiableList2 ));
        interviewers.add(new Interviewer("Bob", modifiableList3));
       // interviewers.add(new Interviewer("Ishan", List.of(3, 4, 5)));
      //  interviewers.add(new Interviewer("Shah", List.of(1,3, 4, 5,7,8)));


        List<Integer> cmodifiableList = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> cmodifiableList2 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        cmodifiableList2.removeIf(n -> n == 1|| n==2 || n==5);
        List<Integer> cmodifiableList3 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        cmodifiableList3.removeIf(n -> n == 1|| n==2);


        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("Candidate1", cmodifiableList));
        candidates.add(new Candidate("Candidate2", cmodifiableList2));
        candidates.add(new Candidate("Candidate3", cmodifiableList3));
        //candidates.add(new Candidate("Candidate4", List.of(4, 5,7,8)));

        Map<String, Map<String,Integer>> calendar = generateCalendar(interviewers, candidates);

        for (String interviewer : calendar.keySet()) {
            System.out.println("Interviewer: " + interviewer);
            System.out.println("Scheduled Candidates: " + calendar.get(interviewer).entrySet());
            System.out.println();
        }
    }

    private static Map<String, Map<String,Integer>> generateCalendar(List<Interviewer> interviewers, List<Candidate> candidates) {
        Map<String, Map<String,Integer>> calendar = new HashMap<>();

        for (int i=0;i< interviewers.size() ;i++) {
            calendar.put(interviewers.get(i).name, new HashMap<>());
            for (Candidate candidate : candidates) {
                boolean isAvailable = true;
                for (int preference : candidate.preferences) {
                    if (!interviewers.get(i).availability.contains(preference)) {
                        //isAvailable = false;

                    }else{
                        calendar.get(interviewers.get(i).name).put(candidate.name,preference);
                        List<Integer> availability = interviewers.get(i).availability;


                        availability.remove(availability.indexOf(preference));
                        candidate.preferences.remove(candidate.preferences.indexOf(preference));
                        candidate.scheduledFor++;

                    }
                    break;
                }

            }
        }

        return calendar;

    }


}
class Interviewer {
    String name;
    List<Integer> availability;

    List<String> candidatesInterviewing;

    Interviewer(String name, List<Integer> availability) {
        this.name = name;
        this.availability =  availability;
    }
}

class Candidate {
    String name;
    List<Integer> preferences;

    int scheduledFor=0;
    Candidate(String name, List<Integer> preferences) {
        this.name = name;
        this.preferences = preferences;
    }
}
