/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.coinbase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CurrencyConverter {

    public static void main(String[] args) {
        // Sample input
        String[] rates = {"USD", "JPY", "110", "USD", "AUD", "1.45", "JPY", "GBP", "0.0070"};
        String[] currencyPair = {"GBP", "AUD"};

        double conversionRate = findConversionRate(rates, currencyPair);
        System.out.println("Conversion Rate from " + currencyPair[0] + " to " + currencyPair[1] + " is: " + conversionRate);
    }

    private static double findConversionRate(String[] rates, String[] currencyPair) {

        // Create a graph of currency conversions
        Map<String, Map<String, Double>> conversionMap = new HashMap<>();


        for (int i = 0; i < rates.length; i += 3) {
            String fromCurrency = rates[i];
            String toCurrency = rates[i + 1];
            double rate = Double.parseDouble(rates[i + 2]);

            conversionMap.putIfAbsent(fromCurrency, new HashMap<>());
            conversionMap.get(fromCurrency).put(toCurrency, rate);
        }
         // Currencies that we want to convert now
        String fromCurrency = currencyPair[0];
        String toCurrency = currencyPair[1];

        // Use a Set to keep track of visited currencies
        Set<String> visited = new HashSet<>();
        return dfsConvert(conversionMap, fromCurrency, toCurrency, 1.0, visited);


    }

    private static double dfsConvert(Map<String, Map<String, Double>> conversionMap, String fromCurrency, String toCurrency, double currentRate, Set<String> visited) {

        // If the current currency matches the target, return the accumulated rate
        if (fromCurrency.equals(toCurrency)) {
            return currentRate;
        }

        // Mark the current currency as visited
        visited.add(fromCurrency);

        // Explore the conversion paths
        for (Map.Entry<String, Double> entry : conversionMap.getOrDefault(fromCurrency, new HashMap<>()).entrySet()) {
            String nextCurrency = entry.getKey();
            double rate = entry.getValue();

            if (!visited.contains(nextCurrency)) {
                double conversionResult = dfsConvert(conversionMap, nextCurrency, toCurrency, currentRate * rate, visited);
                if (conversionResult != -1) { // valid conversion found
                    return conversionResult;
                }
            }
        }

        // If no conversion path found, return -1 (or you could throw an exception)
        return -1;

    }
}
