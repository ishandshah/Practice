/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.dnd.TaskScheduler;


import java.util.*;

public class TaskScheduler {
    private Map<Integer, Task> taskMap;
    private Map<Integer, List<Integer>> taskDependencyMap;

    public TaskScheduler() {
        this.taskDependencyMap = new HashMap<>();
        this.taskMap = new HashMap<>();

    }

    /* Add task to dependency map */
    void createTask(String taskDescription, String dueDate, int uniqueTaskId) {

        Task t = new Task(taskDescription, dueDate, uniqueTaskId);
        this.taskMap.put(t.getTaskId(), t);
        this.taskDependencyMap.put(t.getTaskId(), new ArrayList<>());
    }


    // task B is dependent on task A
    public void addDependency(int taskA, int taskB) throws Exception {
        if (!taskMap.containsKey(taskA)) {
            throw new Exception("Incorrect task dependency");
        }
        taskDependencyMap.get(taskA).add(taskB);
    }

    public List<Task> scheduleTasks() {
        List<Task> taskList = new ArrayList<>();
        Stack<Integer> stack = new Stack();

        HashSet<Integer> visitedTasks = new HashSet<>();
             /* Call the recursive helper
           function to store
           Topological Sort starting
           from all tasks one by one
        */
        for (Integer taskId : this.taskMap.keySet()) {
            if (!visitedTasks.contains(taskId)) {
                scheduleTaskUtil(taskId, visitedTasks, stack);

            }

        }

        // pop contents of stack
        while (!stack.empty()) {
            taskList.add(this.taskMap.get(stack.pop()));
        }

        return taskList;
    }

    private void scheduleTaskUtil(Integer taskId, HashSet<Integer> visitedTasks, Stack<Integer> stack) {
        /* Add taskId to visited */
        visitedTasks.add(taskId);
        Integer thisTask;

        Iterator<Integer> iterator = taskDependencyMap.get(taskId).iterator();

        while (iterator.hasNext()) {
            thisTask = iterator.next();
            if (!visitedTasks.contains(thisTask)) {
                scheduleTaskUtil(thisTask, visitedTasks, stack);
            }

        }
        // Push current taskId to stack
        stack.push(taskId);

    }
}
