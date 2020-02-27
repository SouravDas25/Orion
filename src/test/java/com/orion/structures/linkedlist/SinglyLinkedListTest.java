package com.orion.structures.linkedlist;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.Iterator;

public class SinglyLinkedListTest {

    private static Logger log = LogManager.getLogger(SinglyLinkedListTest.class);

    @Test
    public void main() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

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