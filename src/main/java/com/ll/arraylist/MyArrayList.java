package com.ll.arraylist;

import java.util.ArrayList;

public class MyArrayList<T> {
    private int capacity = 1;
    private int size = 0;
    private Object[] data = new Object[capacity];

    public int size(){
        return size;
    }

    public boolean add(T o){
        if(capacity == size)
            expand();

        data[size++] = o;
        return true;
    }

    public void addFirst(T o) {
        add(0, o);
    }

    public boolean add(int index, T o){
        if(capacity == size)
            expand();

        for(int i=size; i>index; i--){
            data[i] = data[i - 1];
        }
        data[index] = o;
        size++;

        return true;
    }

    public T get(int index) {
        return (T)data[index];
    }

    public T remove(int index) {
        T value = (T)data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;

        return value;
    }

    public boolean contains(T o) {
        for(int i=0; i<size; i++){
            if(data[i] == o)
                return true;
        }
        return false;
    }

    public long indexOf(T o) {
        for(int i=0; i<size; i++){
            if(data[i].equals(o))
                return i;
        }
        return -1;
    }

    public void clear() {
        while(size > 0){
            remove(size - 1);
        }
    }
    private void expand() {
        capacity *= 2;

        Object[] tmp = new Object[capacity];

        relocate(tmp, data);
        data = new String[capacity];
        relocate(data, tmp);
    }

    private void relocate(Object[] tmp, Object[] data) {
        for(int i=0; i<size; i++){
            tmp[i] = data[i];
        }
    }

}
