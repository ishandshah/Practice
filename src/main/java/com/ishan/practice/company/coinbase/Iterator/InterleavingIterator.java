/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ishan.practice.company.coinbase.Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class InterleavingIterator<Integer> implements MyIterator<Integer> {
    private final List<List<Integer>> lists;
    private int currentListIndex = 0;
    private int currentElementIndex = 0;
    private final int totalLists;

    private  int totalElements=0;

    public InterleavingIterator(List<List<Integer>> lists) {
        this.lists = lists;
        this.totalLists = lists.size();
         this.totalElements = lists.stream().mapToInt(List::size).sum();
    }

    @Override
    public boolean hasNext() {
        return totalElements!=0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        // Find the next valid element
        while (true ) {
            if (currentListIndex >= totalLists) {
                currentListIndex = 0; // Wrap around to the beginning
                currentElementIndex++;  // Move to the next element in the next round
            }
            int index = (currentListIndex % totalLists);
            if (currentElementIndex < lists.get(index).size()) {
                // Move to the next list for future calls
                currentListIndex++;
                totalElements--;
                return lists.get(index).get(currentElementIndex);
            }
            // Move to the next element index
            currentListIndex++;

        }

    }


    public static void main(String[] args) {
        // Test InterleavingIterator
        //List<List<Integer>> input = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6), List.of(), List.of(7, 8, 9));
       // InterleavingIterator interleavingIterator = new InterleavingIterator(input);

      /*  System.out.print("Interleaving Output: ");
        while (interleavingIterator.hasNext()) {
            System.out.print(interleavingIterator.next() + " ");
        }*/
        System.out.println();
/*
        // Test RangeIterator
        System.out.print("Range Output: ");
        RangeIterator rangeIterator = new RangeIterator(0, 10, 2);
        while (rangeIterator.hasNext()) {
            System.out.print(rangeIterator.next() + " ");
        }
        System.out.println();

        // Test CycleIterator
        System.out.print("Cycle Output (10 times): ");
        CycleIterator cycleIterator = new CycleIterator(new RangeIterator(0, 5, 1));
        for (int i = 0; i < 10; i++) {
            System.out.print(cycleIterator.next() + " ");
        }
        System.out.println();*/
    }
}
