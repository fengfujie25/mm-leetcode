package com.maomao.leetcode.solution.sort;

/**
 * @auther: fujie.feng
 * @DateT: 2019-12-24
 */
public class AppTest {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 6, 5,20,39,19,11,33,45,23,23,56};
//        BaseSort bubbleSort = new BubbleSort(a);
//        BaseSort selectionSort = new SelectionSort(a);
//        BaseSort shellSort = new ShellSort(a);
//        shellSort.execute();
//        MergeSort mergeSort = new MergeSort();
//        int[] b = mergeSort.sort(a);
//        for (int i = 0; i < b.length; i++) {
//            System.out.println(b[i]);
//        }

        BaseSort mergeSort = new RadixSort(a);
        mergeSort.execute();
    }
}
