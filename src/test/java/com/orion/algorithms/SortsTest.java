package com.orion.algorithms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.*;

public class SortsTest {

    private static Logger log = LogManager.getLogger(SortsTest.class);

    @Test
    public void bubbleSort() {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(6);
        list.add(6);
        list.add(3);
        list.add(9);
        list.add(7);
        list.add(5);
        log.info("{}, ", list);
        Sorts.heapify(list);
        log.info("{}, ", list);
    }
}