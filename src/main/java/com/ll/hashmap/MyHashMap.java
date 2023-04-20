package com.ll.hashmap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {
    private List<K> key;
    private List<V> value;

    public MyHashMap(){
        key = new ArrayList<>();
        value = new ArrayList<>();
    }

    public int size() {
        return key.size();
    }

    public void put(K k, V v) {
        if(key.contains(k)){
            value.remove(key.indexOf(k));
            value.add(key.indexOf(k), v);
            return;
        }

        key.add(k);
        value.add(v);
    }

    public V get(K k) {
        if(key.contains(k)){
            return value.get(key.indexOf(k));
        }

        return null;
    }

    public V remove(K k) {
        if (!key.contains(k)) {
            return null;
        }

        V v = value.get(key.indexOf(k));
        key.remove(key.indexOf(k));
        value.remove(v);

        return v;
    }

    public boolean containsKey(K k) {
        return key.contains(k);
    }

    public boolean containsValue(V v) {
        return value.contains(v);
    }

    public boolean isEmpty() {
        return key.size()==0 && value.size()==0;
    }

    public void clear() {
        key.clear();
        value.clear();
    }
}
