/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.chewypractice;

import com.ishan.leetcode.company.chewypractice.parkinglot.ParkingLot;
import com.ishan.leetcode.company.chewypractice.parkinglot.Ticket;
import com.ishan.leetcode.company.chewypractice.parkinglot.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {

    private ParkingLot parkingLot;
    private Vehicle car1;
    private Vehicle car2;
    private Vehicle car3;

    private Ticket ticket;
    @BeforeEach
    public void setup() {
        parkingLot = new ParkingLot(2);
        car1 = new Vehicle("ABC123", "Car");
        car2 = new Vehicle("XYZ789", "Car");
        car3 = new Vehicle("DEF456", "Car");



    }


    @Test
    public void testParkAndUnpark() {
        Assertions.assertTrue(parkingLot.park(car1));
        Assertions.assertTrue(parkingLot.park(car2));

        // Test parking lot is full
        Assertions.assertFalse(parkingLot.park(car3));

        // Test un parking a vehicle
        parkingLot.unpark(car1);
        Assertions.assertTrue(parkingLot.park(car3));
    }

    @Test
    public void testIsFullAndAvailableSpots() {
        Assertions.assertFalse(parkingLot.isFull());
        Assertions.assertEquals(2, parkingLot.getParkingSpotList().size());

        parkingLot.park(car1);

        Assertions.assertFalse(parkingLot.isFull());
        Assertions.assertEquals(1, parkingLot.getParkingSpotList().size());

        parkingLot.park(car2);

        Assertions.assertTrue(parkingLot.isFull());
        Assertions.assertEquals(0, parkingLot.getParkingSpotList().size());

        parkingLot.unpark(car1);

        Assertions.assertFalse(parkingLot.isFull());
        Assertions.assertEquals(1, parkingLot.getParkingSpotList().size());
    }

    @Test
    public void testTicketGeneration() {
        Assertions.assertTrue(parkingLot.park(car1));
        Ticket ticket = generateTicket(car1);
        Assertions.assertEquals(ticket, car1.getTicket());
    }


}
