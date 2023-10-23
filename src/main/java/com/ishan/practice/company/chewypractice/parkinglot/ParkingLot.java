/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.chewypractice.parkinglot;

import java.util.ArrayList;
import java.util.List;

/*
 * ParkingLot: Represents the parking lot itself and manages the availability of parking spots.
 */
public class ParkingLot {
    int capacity;
    List<ParkingSpot> parkingSpots;

    boolean availabilityStatus;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSpots = new ArrayList<>(capacity);
        // Initialize parking spots
        for (int i = 0; i < capacity; i++) {
            parkingSpots.add(new ParkingSpot(i));

        }
    }

    public boolean park(Vehicle vehicle) {
        if (isFull()) {
            return false; // Parking lot is full
        }
        // Find an available spot
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable) {
                spot.occupy(vehicle);
                return true; // Vehicle parked successfully
            }
        }
        return false; // No available spots
    }

    public void unpark(Vehicle vehicle) {
        // Find the spot occupied by the vehicle
        for (ParkingSpot spot : parkingSpots) {
            if (spot.vehicle == vehicle) {
                spot.vacate();
                return;
            }
        }
    }

    public List<ParkingSpot> getParkingSpotList() {
        List<ParkingSpot> returnList = new ArrayList<>();
        int count = 0;
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable) {
                returnList.add(spot);
            }
        }
        return returnList;
    }

    public boolean isFull() {
        // Check if all spots are occupied
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable) {
                return false; // At least one spot is available
            }
        }
        return true; // All spots are occupied
    }
}
