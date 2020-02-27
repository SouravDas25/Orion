package com.orion.structures.linkedlist;

import com.orion.interfaces.List;

import java.util.Iterator;

public class LinkedList<T> implements List<T>, Iterable<T> {

    protected Node<T> head;
    protected Node<T> tail;
    protected Node<T> now;
    protected int currentIndex;
    protected int size;

    public LinkedList() {
        this.size = 0;
    }

    private void verifyIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<T> traverse(int distanceFromHead) {
        int distanceFromTail = Math.abs(size - distanceFromHead - 1);
        int distanceFromLastIndex = Math.abs(this.currentIndex - distanceFromHead);
        if (distanceFromHead < distanceFromLastIndex && distanceFromHead < distanceFromTail) {
            Node<T> node = this.head;
            for (int i = 0; i <= distanceFromHead; i++) {
                node = node.next;
            }
            return node;
        } else if (distanceFromTail < distanceFromLastIndex && distanceFromTail < distanceFromHead) {
            Node<T> node = this.tail;
            for (int i = 0; i <= distanceFromTail; i++) {
                node = node.prev;
            }
            return node;
        }
        Node<T> node = this.now;
        int till = Math.max(this.currentIndex, distanceFromHead);
        int from = Math.min(this.currentIndex, distanceFromHead);
        for (int i = from; i <= till; i++) {
            node = node.prev;
        }
        this.now = node;
        this.currentIndex = distanceFromHead;
        return node;
    }

    @Override
    public T get(int index) {
        verifyIndex(index);
        return traverse(index).data;
    }

    @Override
    public void append(T value) {
        if (this.tail == null) {
            this.tail = new Node<>();
            this.head = this.tail;
            this.now = this.head;
            this.currentIndex = 0;
            this.tail.data = value;
        } else {
            this.tail.next = new Node<T>();
            this.tail.next.prev = this.tail;
            this.tail = this.tail.next;
            this.tail.data = value;
        }
        this.size++;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(this);
    }

    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;
    }
}
