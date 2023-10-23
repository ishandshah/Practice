/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd.company;

import java.util.*;

public class Company {

    private String companyType;
    private String companyAddress;

    private String companyName;

    private List<Company> relations;

    public Company(String companyType, String companyAddress, String companyName, List<Company> relations) {
        this.companyType = companyType;
        this.companyAddress = companyAddress;
        this.companyName = companyName;
        this.relations = relations;
    }

    public Company(String companyType, String companyAddress, String companyName) {
        this.companyType = companyType;
        this.companyAddress = companyAddress;
        this.companyName = companyName;
        this.relations = new ArrayList<>();
    }

    public Company(String companyName) {
        this.companyName = companyName;
        this.relations = new ArrayList<>();
    }


    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Company> getRelations() {
        return relations;
    }

    public void setRelations(List<Company> relations) {
        this.relations = relations;
    }

    public int getDegreeOfSeparation(Company cC) {

        int deg = 0;
        Queue<Company> companyQueue = new LinkedList<>();
        HashSet<String> visitedCompanies = new HashSet<>();

        // Same tier added all
        companyQueue.addAll(this.getRelations());
        // Kinda level order traversal
        while (!companyQueue.isEmpty()) {
            int size = companyQueue.size(); // Record the size before we add more
            for (int counter = 0; counter < size; counter++) {
                Company thisCompany = companyQueue.remove();
                if (thisCompany.getCompanyName().equals(cC.getCompanyName())) {
                    return deg;
                }
                if (visitedCompanies.contains(thisCompany.getCompanyName())) {
                    continue;
                }
                visitedCompanies.add(thisCompany.getCompanyName());
                companyQueue.addAll(thisCompany.getRelations());


            }
            deg++;
        }


        return -1;

    }

    public void addRelationship(Company cB) {
        this.relations.add(cB);
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                '}';
    }

}
