package com.orion.interfaces;

public interface List<T>{

    T get(int index);

    void append(T value);

    int size();
}
