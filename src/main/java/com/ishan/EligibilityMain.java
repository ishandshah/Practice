/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;


/*

// write a script that will calculate when an employee has become eligible for a 401k

// rules
// - an employee is eligible if the number of days they have worked for a company meets the eligiblity requirement
// - an employee can be hired, terminated, and re-hired at any time
// - an employee can work multiple employments at the same time, but overlapping days only count as 1 day towards eligibility
// - the eligibility date can be in the past or future
// - the eligibility date should be null if the employee will not be eligible
 */
public class EligibilityMain {

    public static void main(String[] args) {
        Employee employee = new Employee(
                new Company(15),
                Arrays.asList(
                        new Employment(createDate("2023-01-01"), createDate("2023-01-31"))
                )
        );

        Employee employee2 = new Employee(
                new Company(30),
                Arrays.asList(
                        new Employment(createDate("2023-01-01"), createDate("2023-01-15")),
                        new Employment(createDate("2023-02-01"), createDate("2023-02-15"))
                )
        );

        Employee employee3 = new Employee(
                new Company(30),
                Arrays.asList(
                        new Employment(createDate("2023-01-01"), createDate("2023-01-20")),
                        new Employment(createDate("2023-01-15"), null)
                )
        );

        Employee employee4 = new Employee(
                new Company(90),
                Arrays.asList(
                        new Employment(createDate("2023-01-01"), createDate("2023-01-31"))
                )
        );
        List<Employee> employeeList=new ArrayList<>();
        //employeeList.add(employee);
        //employeeList.add(employee2);
        employeeList.add(employee3);
      //  employeeList.add(employee4);
            int j=0;
        for(Employee employee1:employeeList){

        // Code here
        System.out.println("Employee:" + ++j);
        System.out.println("Eligibility Requirement: " + employee1.company.eligibilityRequirement);
        System.out.println("Employment Details:");
        boolean isEligible=false;
        // seconds instead of millis
        long remainingEligibilityCriteria=(employee1.company.eligibilityRequirement ) * 86400;
        System.out.println("remainingEligibilityCriteria Details: " + remainingEligibilityCriteria);
        long eligibilityDateTime=0l;
        long previousTerminationTime=0l;
        for (int i=0;i<employee1.employments.size();i++) {
            System.out.println("Hire Date: " + employee1.employments.get(i).hireDate);
            System.out.println("Termination Date: " + employee1.employments.get(i).terminationDate);
            Employment employment = employee1.employments.get(i);
            Long hireDateTime=employment.hireDate.toInstant().toEpochMilli()/1000;



            if(employment.terminationDate==null){
                isEligible=true;
                eligibilityDateTime=hireDateTime+remainingEligibilityCriteria;
                break;
            }



            Long terminationDateTime=employment.terminationDate.toInstant().toEpochMilli() / 1000;

            if(i==0){
                previousTerminationTime=terminationDateTime;
            }else if((previousTerminationTime>hireDateTime)){
                hireDateTime=previousTerminationTime;
                previousTerminationTime=terminationDateTime;
            }


            if(terminationDateTime-hireDateTime >=  remainingEligibilityCriteria - 86400){
                isEligible=true;
                System.out.println("remainingEligibilityCriteria " + remainingEligibilityCriteria);
                eligibilityDateTime=hireDateTime + remainingEligibilityCriteria;
            }else{
                remainingEligibilityCriteria=remainingEligibilityCriteria-(terminationDateTime-hireDateTime + 86400);
                System.out.println("remaining remaion" + remainingEligibilityCriteria);
            }

        }

        if(isEligible || remainingEligibilityCriteria==0){
            System.out.println("Employee will be eligible on: " + Instant.ofEpochMilli(eligibilityDateTime * 1000));
        }

            System.out.println(" ~~~~~~ ~~~~~~ ~~~~~~ ~~~~~~ ");
    }
    }
    private static Date createDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}