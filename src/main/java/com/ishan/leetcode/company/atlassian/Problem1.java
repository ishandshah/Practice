/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassian;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
public class Problem1 {
    /**
     * Process a list of ballots, and return all candidates sorted in descending order by their total number of points.
     */
    public static List<String> getResults(List<Ballot> ballots){

        Map<String,Integer> voteCount=new HashMap<>();
        //
        Map<String,Integer> firstCandidate=new HashMap<>();
        int[] votingPoints=new int[]{3,2,1};
        int max=0;

        String candiateWinner="";
        for(Ballot ballotInst:ballots){
            // 3
            List<Candidate> candidateNames=ballotInst.votingList;

            for(int i=0;i<candidateNames.size();i++){

                String candidateName=candidateNames.get(i).candidateName;


                if(voteCount.containsKey(candidateName)){
                    int currentCount=voteCount.get(candidateName) + votingPoints[i];
                    if(max<currentCount){
                        max=currentCount;
                        candiateWinner=candidateName;
                    }
                    voteCount.put(candidateName,voteCount.get(candidateName) + votingPoints[i]);

                }else{
                    if(max<votingPoints[i]){
                        max=votingPoints[i];
                        candiateWinner=candidateName;
                    }
                    voteCount.put(candidateName,votingPoints[i]);
                }


            }


        }

        // List<String> candidateList=new ArrayList<>(voteCount.keySet());
        //candidateList.sort( c);
        List<String> personList=new ArrayList<>();

        List<String> sorted =voteCount.
                entrySet().
                stream().
                sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .map(Map.Entry::getKey).collect(Collectors.toList());;
        ;
        // 2
        // candidate get1 st
        //declare the winner
        System.out.println(candiateWinner);
        System.out.println(max);
        return sorted;
    }




    public static void main(String[] args) {
        Problem1 solution=new Problem1();
        Candidate candidate1=solution.new Candidate("Ishan");

        Candidate candidate2=solution.new Candidate("Shah");
        Candidate candidate3=solution.new Candidate("Penny");
        List<Candidate> ballot1=new ArrayList<>();

        // 3,2,1
        // 3
        //2
        //1
        ballot1.add(candidate1);
        ballot1.add(candidate3);
        ballot1.add(candidate2);
        Ballot byVoter1=solution.new Ballot(ballot1);

        List<Candidate> ballot2=new ArrayList<>();
        ballot2.add(candidate2);
        ballot2.add(candidate3);
        ballot2.add(candidate1);
        Ballot byVoter2=solution.new Ballot(ballot2);

        //  expected answer candiate1 4, candiate2 5 , candiate3 3
        // 2, 1 , 3
        List<Ballot> lBallots=new ArrayList<>();
        lBallots.add(byVoter1);
        lBallots.add(byVoter2);
        List<String> resultSet= getResults(lBallots);
        System.out.println(resultSet);
    }

    class Ballot{
        // voter - 1 ballot
        List<Candidate> votingList;

        public Ballot(List<Candidate> ballotList){
            this.votingList=ballotList;
        }

    }
    class Candidate{

        String candidateName;

        int currentPoints;

        int firstVote;

        public Candidate(String candidateName){
            this.candidateName=candidateName;
            this.currentPoints=0;
        }

    }

}

