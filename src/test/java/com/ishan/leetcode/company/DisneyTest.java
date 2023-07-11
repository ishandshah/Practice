/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class DisneyTest {

    Disney disney;

    Disney.ParkingGarage parkingGarage;
    Disney.Vehicle vehicle;
    @BeforeEach
    public void populateVehicle(){
        disney=new Disney();
        parkingGarage=new Disney().new ParkingGarage(10,0.05);
        vehicle=new Disney.Vehicle("Tesla");

    }

    @Test
    public void park(){
//        assertEquals(Boolean.TRUE,parkingGarage.park(vehicle));
//        when(parkingGarage.park(vehicle)).thenReturn(Boolean.TRUE);
    }

    @Test
    public void exit(){

        //assertEquals(Boolean.TRUE,parkingGarage.park(vehicle));
        parkingGarage.park(vehicle);
        parkingGarage.exit(vehicle);
//        parkingGarage.hashMap.get(anyLong()).isNaN();
    }
}
