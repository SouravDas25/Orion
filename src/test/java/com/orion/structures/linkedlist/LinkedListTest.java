package com.orion.structures.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class LinkedListTest {

    private static Logger log = LogManager.getLogger(LinkedListTest.class);

    @Test
    public void main() {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.append(30);
        list.append(30);
        list.append(30);

        Iterator iterator = list.iterator();

        log.info("[ ");
        while(iterator.hasNext()) {
            log.info("{}, ", iterator.next());
        }
        log.info(" ]");
    }

}