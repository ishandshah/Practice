/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.functional.CH2_FirstClassFunctions;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    static public List<Customer> allCustomers = new ArrayList<>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;


    public Customer(Integer id, String name, String address, String state, String primaryContact, String domain, Boolean enabled) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.state = state;
        this.primaryContact = primaryContact;
        this.domain = domain;
        this.enabled = enabled;
    }

    public static List<String> getEnabledCustomerNames() {
        return Customer.getEnabledCustomerField(new CustomerName());

    }

    public static List<String> getEnabledCustomerStates() {
        return Customer.getEnabledCustomerField(new CustomerState());
    }

    public static List<String> getEnabledCustomerPrimaruContacts() {
        return Customer.getEnabledCustomerField(new CustomerPrimaryContact());

    }

    public static List<String> getEnabledCustomerDomains() {
        return Customer.getEnabledCustomerField(new CustomerDomain());

    }

    public static List<String> getEnabledCustomerAddress() {
        return Customer.getEnabledCustomerField(new CustomerAddress());
    }

    public static <B> List<B> getEnabledCustomerField(ConversionFunction<Customer, B> func) {
        List<B> enabledCustomers = new ArrayList<>();
        for (Customer customer : Customer.allCustomers) {
            if (customer.enabled) {
                enabledCustomers.add(func.call(customer));
            }
        }
        return enabledCustomers;

    }

    public static void main(String[] args) {
        Customer customer = new Customer(1, "ishan", "golden", "ca", "himani", ".com", true);
        Customer customer2 = new Customer(2, "shah", "vista", "CA", "Mehta", ".org", true);
        allCustomers.add(customer2);
        allCustomers.add(customer);

        System.out.println(getEnabledCustomerAddress());
    }

    static class CustomerId implements ConversionFunction<Customer, Integer> {

        @Override
        public Integer call(Customer customer) {
            return customer.id;
        }
    }

    static class CustomerName implements ConversionFunction<Customer, String> {

        @Override
        public String call(Customer customer) {
            return customer.name;
        }
    }

    static class CustomerAddress implements ConversionFunction<Customer, String> {

        @Override
        public String call(Customer customer) {
            return customer.address;
        }
    }

    static class CustomerState implements ConversionFunction<Customer, String> {

        @Override
        public String call(Customer customer) {
            return customer.state;
        }
    }

    static class CustomerPrimaryContact implements ConversionFunction<Customer, String> {

        @Override
        public String call(Customer customer) {
            return customer.primaryContact;
        }
    }

    static class CustomerDomain implements ConversionFunction<Customer, String> {

        @Override
        public String call(Customer customer) {
            return customer.domain;
        }
    }

    static class CustomerEnabled implements ConversionFunction<Customer, Boolean> {

        @Override
        public Boolean call(Customer customer) {
            return customer.enabled;
        }
    }
}

