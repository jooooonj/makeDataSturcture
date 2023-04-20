package com.ll.hashmap;

public class MyHashMap<K, V> {

    private int size = 0;
    private int capacity = 16;
    private Object[] value;


    public MyHashMap(){
        value = new Object[capacity];
    }

    static final int hash(Object key) { int h; return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); }

    public int getHashIndex(K k){
        return hash(k) % capacity;
    }

    private void expand() {
        capacity *= 2;

        Object[] tmp = new Object[capacity];

        relocate(tmp, value);
        value = new Object[capacity];
        relocate(value, tmp);
    }

    private void relocate(Object[] tmp, Object[] data) {
        for(int i=0; i<size; i++){
            tmp[i] = data[i];
        }
    }

    public int size() {
        return size;
    }

    public void put(K k, V v) {
        int index = getHashIndex(k);

        if(value[index]==null)
            size++;

        value[index] = v;
    }

    public V get(K k) {
        int index = getHashIndex(k);

        return (V) value[index];
    }

    public V remove(K k) {
        int index = getHashIndex(k);

        V value = (V) this.value[index];

        if(value!=null){
            this.value[index] = null;
            size--;
        }

        return value;
    }

    public boolean containsKey(K k) {
        int index = getHashIndex(k);

        return value[index] != null;
    }

    public boolean containsValue(V v) {
        //검색 알고리즘 사용하면 더 좋을듯
        for (Object o : value) {
            V val = (V)o;
            if(val==null) continue;
            if(val.equals(v))
                return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void clear() {
        value = new Object[capacity];
        size = 0;
    }
}
