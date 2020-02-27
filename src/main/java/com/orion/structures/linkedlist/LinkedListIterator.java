package com.orion.structures.linkedlist;

import java.util.ListIterator;

public class LinkedListIterator<T> implements ListIterator<T> {

    protected LinkedList<T> list;

    public LinkedListIterator(LinkedList<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.now != null;
    }

    @Override
    public T next() {
        T data = list.now.data;
        list.now = list.now.next;
        list.currentIndex++;
        return data;
    }

    @Override
    public boolean hasPrevious() {
        return list.now != null;
    }

    @Override
    public T previous() {
        T data = list.now.data;
        list.now = list.now.prev;
        list.currentIndex--;
        return data;
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(T t) {

    }

    @Override
    public void add(T t) {

    }
}
