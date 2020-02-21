package com.orion.interfaces;

public interface List<T> {

    T get(long index);

    void append(T value);

    long size();
}
