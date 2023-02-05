/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
/*
*
Input: King(the first monarch) has 3 children Andy, Bob, Catherine. Andy has one child Matthew. Bob has two children Alex and Asha. Catherine has no children.
Output: [King, Andy, Matthew, Bob, Alex, Asha, Catherine]
* */

// n-ary and DFS
public class Monarchy implements Monarch {

    HashMap<String, Person> personMap;
    String king;


    public Monarchy(String aKing) {
        personMap = new HashMap<>();
        king = aKing;
        personMap.put(king, new Person(king));
    }

    public static void main(String[] args) {
        Monarchy m = new Monarchy("king");
        m.birth("andy", "king");
        m.birth("bob", "king");
        m.birth("cath", "king");
        m.birth("matt", "andy");
        m.birth("alex", "bob");
        m.birth("asha", "bob");
        List<String> list = m.getOrderOfSuccession();
        System.out.println(list.toString());
    }

    @Override
    public void birth(String child, String parent) {
        //Get the parent
        Person parentObj = personMap.get(parent);
        //Generate person
        Person childObj = new Person(child);
        //add the child to parent's child list
        parentObj.children.add(childObj);
        //add child to personMap for future generations
        personMap.put(child, childObj);
    }

    @Override
    public void death(String name) {
        personMap.get(name).isDead = true;
    }

    @Override
    public List<String> getOrderOfSuccession() {
        List<String> succession = new ArrayList<>();
        Stack<Person> stack = new Stack<>();
        stack.push(personMap.get(king));

        while (!stack.empty()) {
            Person current = stack.pop();
            if (!current.isDead) succession.add(current.name);
            for (int i = current.children.size() - 1; i >= 0; i--) {
                stack.push(current.children.get(i));
            }
        }
        return succession;
    }
}

class Person {
    public String name;
    public List<Person> children;
    public Boolean isDead;

    public Person(String aName) {
        name = aName;
        isDead = false;
        children = new ArrayList<>();
    }
}
