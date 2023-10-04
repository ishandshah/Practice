/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.chewypractice;


import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

//todo try using Builder pattern
public class ReturnTopKElements {

    public static void main(String[] args) {

        int[] inputArray={1,2,3,4};
        Person pp=new Person("ishan",33);
        Person pp2=new Person("Himani",29);
        Person pp4=new Person("Papa",69);
        Person pp3=new Person("Mummy",59);

        Person[] personArray={pp,pp2,pp4,pp3};

        topKElements(inputArray,2);
        topKElementsObject(personArray,2);
        topKElementsObjectReversed(personArray,2);
    }

    private static void topKElementsObjectReversed(Person[] personArray, int i) {
        PriorityQueue<Person> pp1=new PriorityQueue<>(Comparator.comparingInt(Person::getAge).reversed());
        returnTopK(pp1,personArray,i);

    }

    private static void returnTopK(PriorityQueue<Person> pp1, Person[] personArray, int i) {

        for(Person person:personArray){
                 pp1.offer(person);

        }

        while(pp1.size()>i){
            pp1.remove();
        }
        // Print the elements in the PriorityQueue
        while (!pp1.isEmpty()) {
            System.out.println(pp1.poll());
        }

    }

    private static void topKElementsObject(Person[] personArray, int i) {
        PriorityQueue<Person> pp1=new PriorityQueue<>(Comparator.comparingInt(Person::getAge));
        returnTopK(pp1,personArray,i);

    }

    private static void topKElements(int[] inputArray, int i) {
        PriorityQueue<Integer> pp1=new PriorityQueue<>();
        for(Integer person:inputArray){

            while(pp1.size()>=i){
                pp1.remove();
            }

            pp1.offer(person);

        }

        // Print the elements in the PriorityQueue
        while (!pp1.isEmpty()) {
            System.out.println(pp1.poll());
        }

    }

    private static class Person {

        String name;

        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
