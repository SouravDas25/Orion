package com.orion.algorithms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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


}
