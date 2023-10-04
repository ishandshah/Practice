/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.chewypractice.parkinglot;

import java.time.Instant;

/*
Ticket: Represents a parking ticket issued to a vehicle upon entry.

 */
public class Ticket {
    //todo remove comments and implement
/*
    int ticketNumber;

    Instant entryTime;
    Instant exitTime;

    Vehicle vehicle;

    public Ticket(){
       // this.ticketNumber=
    }


    Ticket generateTicket(Vehicle car1) {
        //
        return null;
    }
    @Test
    public void testTicketGeneration() {
        Assertions.assertTrue(parkingLot.park(car1));
        Ticket ticket = generateTicket(car1);
        Assertions.assertEquals(ticket, car1.getTicket());
    }

    @Test
    public void testTicketExpiration() {
        // Set a short duration for testing
        parkingLot.setTicketExpirationDurationMinutes(5);

        Assertions.assertTrue(parkingLot.park(car1));
        Ticket ticket = generateTicket(car1);

        // Simulate the passage of 6 minutes
        LocalDateTime expirationTime = ticket.getEntryTime().plus(6, ChronoUnit.MINUTES);
        car1.getTicket().setExitTime(expirationTime);

        // Vehicle should not be allowed to exit with an expired ticket
        Assertions.assertFalse(parkingLot.unpark(car1));
    }

    @Test
    public void testTicketFeeCalculation() {
        parkingLot.setTicketExpirationDurationMinutes(60);
        parkingLot.setHourlyRate(10);

        Assertions.assertTrue(parkingLot.park(car1));
        Ticket ticket = generateTicket(car1);

        // Simulate the passage of 2 hours
        LocalDateTime exitTime = ticket.getEntryTime().plus(2, ChronoUnit.HOURS);
        car1.getTicket().setExitTime(exitTime);

        double expectedFee = 20.0; // 2 hours * $10 per hour
        double actualFee = parkingLot.calculateFee(car1.getTicket());
        Assertions.assertEquals(expectedFee, actualFee);
    }

    private Ticket generateTicket(Vehicle vehicle) {
        ParkingSpot spot = findParkingSpotByVehicle(vehicle);
        return new Ticket(vehicle, spot.getSpotNumber(), spot.getOccupiedTime());
    }

    private ParkingSpot findParkingSpotByVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingLot.getParkingSpots()) {
            if (spot.getVehicle() == vehicle) {
                return spot;
            }
        }
        return null;
    }
    */

}
