/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.lamda;

import java.util.ArrayList;
import java.util.List;


//TODO RUN URGENTLY
//TODO ADDED OWN LAMBDA TO FILTER DATA
//TODO ADD TEST CASE
public class GenericLambda {


    public static void main(String[] args)
    {
        // Use a String-based version of SomeFunc.
        SomeFunc<String> reverse = (str) -> {
            String result = "";
            int i;
            for(i = str.length()-1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };
        System.out.println("Lambda reversed is " +
                reverse.func("Lambda"));
        System.out.println("Expression reversed is " +
                reverse.func("Expression"));
// Now, use an Integer-based version of SomeFunc.
        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for(int i=1; i <= n; i++)
                result = i * result;
            return result;
        };


        System.out.println("The factoral of 3 is " + factorial.func(3));
        System.out.println("The factoral of 5 is " + factorial.func(5));





        SomeFunc<ApplyFilters> applyFiltersSomeFunc=(applyObj) -> {

            for (ApplyFilters.People people : applyObj.peopleList) {
                if(people.age<10){
                    applyObj.peopleList.remove(people);
                }
            }

            return applyObj;
            //ApplyFilters
        };


        //Test data

        ApplyFilters app=new ApplyFilters();
        app.peopleList=new ArrayList<>(){{
            add(new ApplyFilters.People("ishan",1,'F',1000));
            add(new ApplyFilters.People("shah",100,'F',1000));
            add(new ApplyFilters.People("ishani",11,'F',1000));
            add(new ApplyFilters.People("isha",12,'F',100000));
            add(new ApplyFilters.People("ishane",19,'M',1000));
            add(new ApplyFilters.People("is",9,'F',1000));
        }};
        ApplyFilters func = applyFiltersSomeFunc.func(app);

        System.out.println("THIS HAS TO BE TRUE " + (func.peopleList.size()==4));
    }

}


interface SomeFunc<T>{

    T func(T t);
}

class ApplyFilters{

    List<People> peopleList;


    static class People {
        public People(String name, int age, char sex, int money) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.money = money;
        }

        String name;
        int age;
        char sex;
        int money;


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

        public char getSex() {
            return sex;
        }

        public void setSex(char sex) {
            this.sex = sex;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }
    }
}