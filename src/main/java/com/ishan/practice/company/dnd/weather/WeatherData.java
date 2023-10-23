/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd.weather;

public class WeatherData {
    private int id;
    private String city;
    private int temp;
    private int pressurePsi;
    private int humidity;

    public WeatherData(int id, String city, int temp, int pressure, int humidity) {
        this.id = id;
        this.city = city;
        this.temp = temp;
        this.pressurePsi = pressure;
        this.humidity = humidity;
    }

    public String getCityName() {
        return this.city;
    }

    public int getTemp() {
        return this.temp;
    }

    public int getPressure() {
        return this.pressurePsi;
    }

    public int getHumidity() {
        return this.humidity;
    }

    @Override
    public String toString() {
        return "Weather={" +
                "city='" + city + '\'' +
                "temp=" + temp + '\'' +
                "humidity=" + humidity + '\'' +
                '}';
    }

}
