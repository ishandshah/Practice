/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.designPattern.factory;

public class FactoryDesign {
    public static void main(String[] args) {
        // Create a Concrete Factory 1
        String factory = "factory2";
        switch (factory) {
            case "factory1":

                Factory factory1 = new ConcreteFactory1();
                // Use the factory to create a product
                Product product1 = factory1.createProduct();
                product1.operation();
                break;
            case "factory2":
                // Create a Concrete Factory 2
                Factory factory2 = new ConcreteFactory2();
                // Use the factory to create a product
                Product product2 = factory2.createProduct();
                product2.operation();
                break;
            default:
                // code to be executed if expression does not match any case
                System.out.println("Factory doesn't exist");
                break;
        }
    }

}
