/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd.TaskScheduler;

public class TaskMain {

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();

        /* Add tasks to scheduler */
        taskScheduler.createTask("t0 description", "2020-01-03", 0);
        taskScheduler.createTask("t1 description", "2020-02-03", 1);
        taskScheduler.createTask("t2 description", "2020-12-02", 2);
        taskScheduler.createTask("t3 description", "2020-11-03", 3);
        taskScheduler.createTask("t4 description", "2020-02-05", 4);
        taskScheduler.createTask("t5 description", "2020-03-13", 5);

        /*
         * 0 ->
         * 1 ->
         * 2 -> 3
         * 3 -> 1
         * 4 -> 0, 1
         * 5 -> 2, 0
         * */
        try {
            /* Add task dependency */
            taskScheduler.addDependency(5, 2);
            taskScheduler.addDependency(5, 0);
            taskScheduler.addDependency(4, 0);
            taskScheduler.addDependency(4, 1);
            taskScheduler.addDependency(2, 3);
            taskScheduler.addDependency(3, 1);

        } catch (Exception e) {
            System.out.println(e);
        }


        for (Task t : taskScheduler.scheduleTasks()) {
            System.out.println(t.toString());
        }

    }

}
