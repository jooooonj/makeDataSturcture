package com.ll.exam1;

public class MyArrayList<T> {
    private int capacity = 1;
    private int size = 0;
    private Object[] data = new Object[capacity];

    public int size(){
        return size;
    }

    public boolean add(T data){
        if(capacity == size)
            expand();

        this.data[size++] = data;
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

    public boolean contains(String data) {
        for(int i=0; i<size; i++){
            if(this.data[i] == data)
                return true;
        }
        return false;
    }

    public long indexOf(String value) {
        for(int i=0; i<size; i++){
            if(data[i].equals(value))
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
