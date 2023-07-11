/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassianpractice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/*


You are given two integer arrays persons and times. In an election, the i th vote was cast for persons[i] at time times[i].

For each query at a time t, find the person that was leading the election at time t.
Votes cast at time t will count towards our query. In the case of a tie, the most recent vote (among tied candidates) wins.

Implement the TopVotedCandidate class:

TopVotedCandidate(int[] persons, int[] times) Initializes the object with the persons and times arrays.
int q(int t) Returns the number of the person that was leading the election at time t according to the mentioned rules.


Example 1:

Input
["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
[[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
Output
[null, 0, 1, 1, 0, 0, 1]

Explanation
TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
topVotedCandidate.q(3); // return 0, At time 3, the votes are [0], and 0 is leading.
topVotedCandidate.q(12); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
topVotedCandidate.q(25); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
topVotedCandidate.q(15); // return 0
topVotedCandidate.q(24); // return 0
topVotedCandidate.q(8); // return 1

 */
class TopVotedCandidate {
    TreeMap<Integer, Integer> timedWinner;
    int lead;
    public TopVotedCandidate(int[] persons, int[] times) {
        int n = times.length;
        lead = -1;
        timedWinner = new TreeMap();

        Map<Integer, Integer> votes = new HashMap();

        for(int i=0; i<n; i++){
            votes.put(persons[i], votes.getOrDefault(persons[i], 0)+1);

            if(i==0 || votes.get(persons[i])>=votes.get(lead)){
                lead = persons[i];
            }

            timedWinner.put(times[i], lead);
        }
    }

    public int q(int t) {
        System.out.println(timedWinner.floorEntry(t).getValue());
        return timedWinner.floorEntry(t).getValue();
    }

    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate=new TopVotedCandidate(new int[] {0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        topVotedCandidate.q(3); // return 0, At time 3, the votes are [0], and 0 is leading.
        topVotedCandidate.q(12); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
        topVotedCandidate.q(25); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
        topVotedCandidate.q(15); // return 0
        topVotedCandidate.q(24); // return 0
        topVotedCandidate.q(8); // return 1
    }
}
