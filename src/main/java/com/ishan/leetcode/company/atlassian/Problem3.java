/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.leetcode.company.atlassian;


/*

We want to implement a middleware router for our web service,
which based on the path returns different strings (these would represent “functions to invoke” in a real application).

Our interface for the router looks something like:


interface Router {

  fun withRoute(path: String, result: String) : Unit;

  fun route(path: String) : String;

}

Usage:
Router.addRoute("/bar", "result")
Router.route("/bar") -> "result"

Router.addRoute("/bar", "result2")


Extend the route declarations such that we can have wildcards in the paths.


Router router = Router()
router.withRoute("/foo", "foo")
router.withRoute("/bar/baz", "bar")

        */

//todo //todo try using Builder pattern
public class Problem3 {

    public static void main(String[] args) {
        // RouterBuilder rbr=RouterBuilder().
        RouterImpl router = new RouterImpl();
        router.withRoute("/bar", "result");


        router.withRoute("/foo", "foo");
        router.withRoute("/bar/*/bar", "bar");

        router.withRoute("/foo/{id}/foo", "foo");
        //router.withRoute("/foo/id", "foo");
        //UUID
        System.out.println(router.route("/foo/123e4567-e89b-12d3-a456-426655440000/foo")); // foo
        //System.out.println("Result is " + router.route("/bar"));
        System.out.println(router.route("/bar/sdhjf/bar"));
        System.out.println(router.route("/bar/sdhjf/bar"));
    }


}
