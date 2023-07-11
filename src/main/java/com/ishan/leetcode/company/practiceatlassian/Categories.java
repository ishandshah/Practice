/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.practiceatlassian;

import java.util.ArrayList;
import java.util.List;

public class Categories {


    public static void main(String[] args) {
        // Create the category tree
        Category root = new Category("Root");
        Category category1 = new Category("Category 1");
        Category category2 = new Category("Category 2");
        Category subcategory1 = new Category("Subcategory 1");
        Category subcategory2 = new Category("Subcategory 2");

        root.addSubCategory(category1);
        root.addSubCategory(category2);
        category1.addSubCategory(subcategory1);
        category1.addSubCategory(subcategory2);
        subcategory2.addSubCategory(new Category("Subcategory 3"));
        // Print the category tree
        root.printCategories();
    }

    public static class Category {

        private String name;
        private List<Category> subCategories;

        public Category(String name) {
            this.name = name;
            this.subCategories = new ArrayList<>();
        }

        public void addSubCategory(Category category1) {
            subCategories.add(category1);
        }

        public void printCategories() {
            printCategoriesRecursive(this, 0);
        }

        private void printCategoriesRecursive(Category category, int depth) {
            StringBuilder indent = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                indent.append("    ");
            }

            System.out.println(indent.toString() + category.name);

            for (Category subCategory : category.subCategories) {
                printCategoriesRecursive(subCategory, depth + 1);
            }
        }

    }
}

