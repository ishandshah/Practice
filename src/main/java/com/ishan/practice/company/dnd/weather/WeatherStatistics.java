/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd.weather;


import java.util.*;

/* Design and implement a method which returns Top K cities for a given weather attribute.
attributes:
pressure, humidity, temp
*/
public class WeatherStatistics {

    public static void main(String[] args) {

        List<WeatherData> inputList = new ArrayList<>();

        /* Data setup */
        WeatherData mumbai = new WeatherData(1, "mumbai", 28, 14, 85);
        inputList.add(mumbai);
        WeatherData tokyo = new WeatherData(2, "tokyo", 26, 11, 12);
        inputList.add(tokyo);
        WeatherData seoul = new WeatherData(3, "seoul", 24, 12, 50);
        inputList.add(seoul);
        WeatherData seattle = new WeatherData(4, "seattle", 14, 8, 20);
        inputList.add(seattle);
        WeatherData chicago = new WeatherData(5, "chicago", 2, 14, 21);
        inputList.add(chicago);
        WeatherData paris = new WeatherData(6, "paris", 18, 15, 34);
        inputList.add(paris);
        WeatherData london = new WeatherData(7, "london", 19, 14, 51);
        inputList.add(london);
        WeatherData rome = new WeatherData(8, "rome", 25, 18, 60);
        inputList.add(rome);
        WeatherData auckland = new WeatherData(7, "auckland", 7, 10, 15);
        inputList.add(auckland);
        WeatherData moscow = new WeatherData(8, "moscow", -1, 12, 5);
        inputList.add(moscow);


        WeatherStatistics ws = new WeatherStatistics();

        try {

            TopK tempTopk = ws.getTopKDataByStat(5, "temp", inputList);
            System.out.println(" ********* TEMP ********** ");
            for (WeatherData city : tempTopk.getDataList()) {
                System.out.println(city.toString());
            }

            TopK pressure = ws.getTopKDataByStat(5, "pressure", inputList);

            System.out.println(" ********* PRESSURE ********** ");
            for (WeatherData city : pressure.getDataList()) {
                System.out.println(city.toString());
            }

            TopK humidityTopK = ws.getTopKDataByStat(5, "humidity", inputList);
            System.out.println(" ********* HUMIDITY ********** ");
            try {
                for (WeatherData city : humidityTopK.getDataList()) {
                    System.out.println(city.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            TopK exceptionTest = ws.getTopKDataByStat(50, "humidity", inputList);  //  Expected exception: "Invalid k value"

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.toString());
        }

    }

    private TopK getTopKDataByStat(int k, String stat, List<WeatherData> inputList) throws Exception {

        /* Basic validation */
        if (k < 0 || k > inputList.size()) {
            throw new Exception("Invalid k value");
        }

        TopK topk;

        switch (stat) {
            case "temp":
                topk = getTopKDataByTemp(k, inputList);
                break;
            case "humidity":
                topk = getTopKDataByHumidity(k, inputList);
                break;
            case "pressure":
                topk = getTopKDataByPressure(k, inputList);
                break;
            default:
                throw new Exception("Invalid stat key");
        }

        return topk;


    }

    private TopK getTopKDataByPressure(int k, List<WeatherData> inputList) {
        Collections.sort(inputList, new PressureComparator());
        List<WeatherData> outputList = inputList.subList(0, k);

        TopK topK = new TopK(k, "pressure", outputList);

        return topK;
    }

    private TopK getTopKDataByHumidity(int k, List<WeatherData> inputList) {
        Collections.sort(inputList, new HumidityComparator());
        List<WeatherData> outputList = inputList.subList(0, k);

        TopK topK = new TopK(k, "humidity", outputList);

        return topK;
    }

    private TopK getTopKDataByTemp(int k, List<WeatherData> inputList) {

        PriorityQueue<WeatherData> tempQ = new PriorityQueue(new TempComparator());


        /* add all city data in PQ */
        for (WeatherData cityData : inputList) {
            tempQ.add(cityData);
        }

        List<WeatherData> result = new ArrayList<>();

        int size = k;
        while (size > 0) {
            WeatherData city = tempQ.poll();
            result.add(city);
            size--;
        }


        return new TopK(k, "TEMPERATURE", result);
    }

    public static class TopK {
        private int k;
        private String stat;
        private List<WeatherData> dataList;

        public TopK(int k, String stat, List<WeatherData> dataList) {
            this.k = k;
            this.stat = stat;
            this.dataList = dataList;
        }

        public List<WeatherData> getDataList() {
            return this.dataList;
        }

    }

    private class HumidityComparator implements Comparator<WeatherData> {

        @Override
        public int compare(WeatherData o1, WeatherData o2) {
            if (o1.getHumidity() <= o2.getHumidity()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    private class TempComparator implements Comparator<WeatherData> {
        @Override
        public int compare(WeatherData o1, WeatherData o2) {
            if (o1.getTemp() <= o2.getTemp()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    private class PressureComparator implements Comparator<WeatherData> {
        @Override
        public int compare(WeatherData o1, WeatherData o2) {
            if (o1.getPressure() <= o2.getPressure()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}

