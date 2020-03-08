package com.orion.structures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircularQueueTest {

    @Test
    public void circularQueue() {
        CircularQueue<Integer> circularQueue = new CircularQueue<>(5);
        circularQueue.insertRear(3);
        circularQueue.printQueue();
        circularQueue.insertFront(10);
        circularQueue.printQueue();
        circularQueue.deleteRear();
        circularQueue.printQueue();
        circularQueue.insertFront(12);
        circularQueue.printQueue();
        circularQueue.deleteFront();
        circularQueue.printQueue();

    }
}