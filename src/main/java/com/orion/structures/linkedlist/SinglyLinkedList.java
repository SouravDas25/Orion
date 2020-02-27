package com.orion.structures.linkedlist;


import com.orion.interfaces.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.Spliterator;

public class SinglyLinkedList<T> implements List<T> , Iterable<T> {

    private static Logger log = LogManager.getLogger(SinglyLinkedList.class);
    Node<T> head;
    Node<T> tail;
    int size;

    public SinglyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = this.head;
        for(long i = 0; i < index ; i++){
            current = current.next;
        }
        return current.data;
    }

    public void append(T value) {
        if (this.tail == null) {
            this.tail = new Node<>();
            this.head = this.tail;
            this.tail.data = value;
        } else {
            this.tail.next = new Node<T>();
            this.tail = this.tail.next;
            this.tail.data = value;
        }
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public Iterator<T> iterator() {
        return new SinglyLinkedListIterator<>(this);
    }

    public Spliterator<T> spliterator() {
        return null;
    }

    static class Node<T> {
        T data;
        Node<T> next;
    }
}
