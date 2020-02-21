package com.orion.structures.linkedlist;

import com.orion.structures.linkedlist.SinglyLinkedList;

import java.util.ListIterator;

public class SinglyLinkedListIterator<T> implements ListIterator<T> {

    protected SinglyLinkedList.Node<T> current;

    public SinglyLinkedListIterator(SinglyLinkedList<T> singlyLinkedList) {
        this.current = singlyLinkedList.head;
    }

    @Override
    public boolean hasNext() {
        return current.next != null;
    }

    @Override
    public T next() {
        T data = current.data;
        current = current.next;
        return data;
    }

    @Override
    public boolean hasPrevious() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T previous() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(T data) {
        current.data = data;
    }

    @Override
    public void add(T data) {
        SinglyLinkedList.Node<T> node = new SinglyLinkedList.Node<>();
        node.data = data;
        node.next = current.next;
        current.next = node;
    }
}
