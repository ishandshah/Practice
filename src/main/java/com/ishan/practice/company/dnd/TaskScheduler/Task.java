/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd.TaskScheduler;

public class Task {

    private int uniqueTaskId;
    private String taskDescription;
    private String dueDate;
    private String notes;
    private String assignee;

    /* For simplicity adding uniqueTaskId in constructor */
    public Task(String taskDescription, String dueDate, int uniqueTaskId) {
        this.uniqueTaskId = uniqueTaskId;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
    }

    public int getTaskId() {
        return uniqueTaskId;
    }


    @Override
    public String toString() {
        return "Task{" +
                "uniqueTaskId=" + uniqueTaskId +
                ", taskDescription='" + taskDescription + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }

}
