/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.bill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomComparator {
    List<Person> personList = new ArrayList<>();

    public static void main(String[] args) {
        CustomComparator cc = new CustomComparator();
        cc.Persons();
        //cc.sortPersonList();
        cc.customComparator();

    }

    public void Persons() {


        Person person = new Person("ishan", 12.12, 12, Boolean.TRUE);
        Person person2 = new Person("deval", 13.12, 14, Boolean.TRUE);
        Person person3 = new Person("Himani", 130.12, 10, Boolean.FALSE);
        Person person4 = new Person("Poojan", -12.12, 0, Boolean.FALSE);
        personList.add(person);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

    }


    public void sortPersonList() {

        Collections.sort(personList, Comparator.comparingDouble(Person::getBalance));
        for (Person p : personList) {
            System.out.println(p);
        }
    }


    public void customComparator() {
        Collections.sort(personList, new IshanComparator().reversed());

        for (Person p : personList) {
            System.out.println(p);
        }
    }


}

class IshanComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Double.compare(o1.getBalance(), o2.getBalance());
    }
}

class Person {


    String firstName;

    double balance;

    int age;

    boolean isMale;

    public Person(String firstName, double balance, int age, boolean isMale) {
        this.firstName = firstName;

        this.balance = balance;
        this.age = age;
        this.isMale = isMale;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", balance=" + balance +
                ", age=" + age +
                ", isMale=" + isMale +
                '}';
    }
}