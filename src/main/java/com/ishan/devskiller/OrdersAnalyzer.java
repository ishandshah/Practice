package com.ishan.devskiller;


import java.util.List;
import java.util.Optional;
import java.util.stream.*;
import java.util.function.*;
import java.util.*;

public class OrdersAnalyzer {

    /**
     * Should return at most three most popular products. Most popular product is the product that have the most occurrences
     * in given orders (ignoring product quantity).
     * If two products have the same popularity, then products should be ordered by name
     *
     * @param orders orders stream
     * @return list with up to three most popular products
     */
    public List<Product> findThreeMostPopularProducts(Stream<Order> orders) {
        return orders
                .flatMap(order -> order.getOrderLines().stream())
                .map(OrderLine::getProduct)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Product, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey(Comparator.comparing(Product::getName))))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    /**
     * Should return the most valuable customer, that is the customer that has the highest value of all placed orders.
     * If two customers have the same orders value, then any of them should be returned.
     *
     * @param orders orders stream
     * @return Optional of most valuable customer
     */
    public Optional<Customer> findMostValuableCustomer(Stream<Order> orders) {
        return orders
                .collect(Collectors.groupingBy(Order::getCustomer,
                        Collectors.summingDouble(this::calculateOrderValue)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())

                .map(Map.Entry::getKey);
    }

    // Helper method to calculate the total value of an order
    private double calculateOrderValue(Order order) {
        return order.getOrderLines().stream()
                .mapToDouble(orderLine -> (orderLine.getProduct().getPrice().doubleValue() * orderLine.getQuantity()))
                .sum();
    }

}
