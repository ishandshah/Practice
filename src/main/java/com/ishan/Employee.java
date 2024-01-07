/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan;


import java.util.List;

/*
*
* // write a script that will calculate when an employee has become eligible for a 401k

// rules
// - an employee is eligible if the number of days they have worked for a company meets the eligiblity requirement
// - an employee can be hired, terminated, and re-hired at any time
// - an employee can work multiple employments at the same time, but overlapping days only count as 1 day towards eligibility
// - the eligibility date can be in the past or future
// - the eligibility date should be null if the employee will not be eligible

// // types
// type Company = {
//   eligibilityRequirement: number;
// };

// type Employment = {
//   hireDate: Date;
//   terminationDate?: Date | null;
// };

// type Employee = {
//   company: Company;
//   employments: Employment[];
// };

// type EligibilityFunction = (employee: Employee) => Date | null;
*
* */
public class Employee {
        Company company;
        List<Employment> employments;

        Employee(Company company, List<Employment> employments) {
            this.company = company;
            this.employments = employments;
        }

}
