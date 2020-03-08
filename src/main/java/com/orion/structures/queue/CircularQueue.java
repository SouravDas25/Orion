package com.orion.structures.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CircularQueue<T> {

    private static Logger log = LogManager.getLogger(CircularQueue.class);

    private T[] circularList;
    private int front = -1;
    private int rear = 0;
    private int size;

    public CircularQueue(int size) {
        this.circularList = (T[]) new Object[size];
        this.size = size;
    }

    protected void checkIfFull() {
        if (isFull())
            throw new RuntimeException("Queue Overflow");
    }

    protected void checkIfEmpty() {
        if (isEmpty())
            throw new RuntimeException("Queue Empty");
    }

    boolean isEmpty() {
        return (front == -1);
    }

    boolean isFull() {
        return ((front == 0 && rear == size - 1) ||
                front == rear + 1);
    }

    public void insertFront(T value) {
        checkIfFull();

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0)
            front = size - 1;
        else
            front = front - 1;
        circularList[front] = value;
    }

    public void insertRear(T value) {
        checkIfFull();

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == size - 1)
            rear = 0;
        else
            rear = rear + 1;
        circularList[rear] = value;
    }

    public void deleteFront() {
        checkIfEmpty();
        circularList[front] = null;
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            if (front == size - 1)
                front = 0;
            else
                front = front + 1;
        }

    }

    public void deleteRear() {
        checkIfEmpty();
        circularList[rear] = null;
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0)
            rear = size - 1;
        else
            rear = rear - 1;
    }

    public T front() {
        checkIfEmpty();
        return circularList[front];
    }

    public T rear() {
        checkIfEmpty();
        return circularList[rear];
    }

    public void printQueue() {
        log.info("  {}", Arrays.asList(circularList));
    }
}
