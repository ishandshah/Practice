/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company;

import java.util.*;

public class Disney {

    static  class Vehicle{
        String id;

        public Vehicle(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

    }
    class SpotAssigned{
        Vehicle vehicle;
        int spotNumber;
        long startTime;

    }

   public  class ParkingGarage{
        int capacity;
        double costInSeconds=0.0;
        int vehiclesParked=0;
        boolean[] isOccupied;
        Map<Long,Double> hashMap=new TreeMap<>();
        Map<String,SpotAssigned> spotAssignedMap=new HashMap<>();
        public ParkingGarage(int capacity,double costInSeconds) {
            this.capacity=capacity;
            this.costInSeconds=costInSeconds;
            isOccupied=new boolean[capacity];
        }

        // Randomly assign SPOT
        // anyMath filter
        public boolean park(Vehicle v){
                    if(capacity-vehiclesParked>=0){
                        return false;
                    }
                    //Spot assign

                int randomNumber = 0;
                while(isOccupied[randomNumber]!=Boolean.FALSE){
                    randomNumber=new Random().nextInt(0, capacity);
                }
                isOccupied[randomNumber]=Boolean.TRUE;
                this.vehiclesParked++;


                SpotAssigned spotAssigned=new SpotAssigned();
                spotAssigned.spotNumber=randomNumber;
                spotAssigned.vehicle=v;
                spotAssigned.startTime=System.currentTimeMillis();

                return true;
        }

        //Charge the customer when they exit
        public void exit(Vehicle v){

            if(spotAssignedMap.get(v.getId())==null){
                //exit
                return;
            }

            SpotAssigned spotAssigned = spotAssignedMap.get(v.getId());

            long exitTime=System.currentTimeMillis();


            double cost=this.costInSeconds * (exitTime-spotAssigned.startTime);

            if(hashMap.containsKey(exitTime)){
                hashMap.put(exitTime, hashMap.get(exitTime) + cost);
            }else{
                hashMap.put(exitTime, cost);
            }

            spotAssignedMap.remove(v.getId());
            this.vehiclesParked--;

        }
       // 10 thi 11
        // Inclusive
       public Double getEarnings(long startTime, long endTime){
            double totalEarnings=0.0;
            for(Map.Entry<Long,Double> hs:hashMap.entrySet()){

                if(hs.getKey()>=startTime && hs.getKey()<=endTime){
                    totalEarnings+=hs.getValue();
                }
            }

            return totalEarnings;

        }

    }
}
