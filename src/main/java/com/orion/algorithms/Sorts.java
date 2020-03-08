package com.orion.algorithms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorts {

    private static Logger log = LogManager.getLogger(Sorts.class);

    private static <T extends Comparable<? super T>> int compare(List<T> list, int i, int j) {
        return list.get(i).compareTo(list.get(j));
    }

    private static <T extends Comparable<? super T>> void swap(List<T> list, int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public static <T extends Comparable<? super T>> void bubbleSort(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (compare(list, j, j + 1) > 0) {
                    swap(list, j, j + 1);
                    flag = false;
                }
//                log.info("      {},", list);
            }
//            log.info(" {},", list);
            if (flag) return;
        }
    }

    public static <T extends Comparable<? super T>> void selectionSort(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            int mini = i;
            for (int j = mini; j < list.size(); j++) {
                if (compare(list, mini, j) > 0) {
                    mini = j;
                }
//                log.info("      {},", list);
            }
            swap(list, mini, i);
//            log.info(" {},", list);
        }
    }

    public static <T extends Comparable<? super T>> void insertionSort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T x = list.get(i);
            int j;
            for (j = i - 1; j >= 0 && list.get(j).compareTo(x) > 0; j--) {
                swap(list, j, j + 1);
                log.info("      {},", list);
            }
            list.set(j + 1, x);
            log.info("{} {},", j + 1, list);
        }
    }

    protected static <T extends Comparable<? super T>> void quickSort(List<T> list, int start, int end) {
        if (start >= end) return;
        T pivot = list.get(end);
        int pindex = start;
        for (int i = start; i < end; i++) {
            if (list.get(i).compareTo(pivot) <= 0) {
                swap(list, i, pindex);
                pindex++;
            }
        }
        swap(list, pindex, end);
        quickSort(list, start, pindex - 1);
        quickSort(list, pindex + 1, end);
    }

    public static <T extends Comparable<? super T>> void quickSort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    protected static <T extends Comparable<? super T>> List<T> mergeSort(List<T> list, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            List<T> l1 = mergeSort(list, low, mid);
            List<T> l2 = mergeSort(list, mid + 1, high);
//            log.info(" {} {} ", l1, l2);
            return merge(l1, l2);
        }
        return Collections.singletonList(list.get(low));
    }

    protected static <T extends Comparable<? super T>> List<T> merge(List<T> l1, List<T> l2) {
        List<T> mergedList = new ArrayList<>();
        while (!l1.isEmpty() && !l2.isEmpty()) {
            T right = l2.get(0);
            T left = l1.get(0);
            if (left.compareTo(right) < 0) {
                mergedList.add(left);
                l1.remove(0);
            } else {
                mergedList.add(right);
                l2.remove(0);
            }
        }
        return mergedList;
    }

    public static <T extends Comparable<? super T>> void mergeSort(List<T> list) {
        List<T> sortedList = mergeSort(list, 0, list.size() - 1);
        list.clear();
        list.addAll(sortedList);
    }

    public static <T extends Comparable<? super T>> void heapSort(List<T> list) {

    }

    protected static <T extends Comparable<? super T>> void heapify(List<T> list, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && compare(list, l, largest) > 0)
            largest = l;

        // If right child is larger than largest so far
        if (r < n && compare(list, r, largest) > 0)
            largest = r;

        // If largest is not root
        if (largest != i) {
            swap(list, i, largest);
            log.info("      {}", list);
            heapify(list, n, largest);
        }
    }

    public static <T extends Comparable<? super T>> void heapify(List<T> list) {
        for (int i = list.size() / 2 - 1; i >= 0; i--)
            heapify(list, list.size(), i);
    }


}
