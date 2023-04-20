package com.ll.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class MyHashMapTests {
    private MyHashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap<>();
    }
    @Test
    @DisplayName("size()")
    void t1() {
        assertThat(map.size()).isEqualTo(0);
    }
    @Test
    @DisplayName("put()")
    void t2() {
        map.put("Key1", 1);
        assertThat(1).isEqualTo(map.size());
    }

    @Test
    @DisplayName("이미 있는 값에 put() -> value 교체")
    void t3() {
        map.put("Key1", 1);
        map.put("Key1", 2);
        map.put("Key1", 3);

        assertThat(1).isEqualTo(map.size());
    }

    @Test
    @DisplayName("get()")
    void t4() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertThat(Integer.valueOf(1)).isEqualTo(map.get("Key1"));
        assertThat(Integer.valueOf(2)).isEqualTo(map.get("Key2"));
        assertThat(map.get("Key3")).isEqualTo(null);
    }

    @Test
    @DisplayName("remove()")
    void t5() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertThat(Integer.valueOf(1)).isEqualTo(map.remove("Key1"));

        assertThat(1).isEqualTo(map.size());
    }

    @Test
    @DisplayName("containsKey()")
    void t6() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertThat(map.containsKey("Key1")).isEqualTo(true);
        assertThat(map.containsKey("Key3")).isEqualTo(false);
    }

    @Test
    @DisplayName("containsValue()")
    void t7() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertThat(map.containsValue(1)).isEqualTo(true);
        assertThat(map.containsValue(3)).isEqualTo(false);
    }
    @Test
    @DisplayName("clear()")
    void t8() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);
        map.clear();
        assertThat(0).isEqualTo(map.size());
        assertThat(map.isEmpty()).isEqualTo(true);
    }

    @Test
    @DisplayName("해시값 확인")
    void t9() {
        map.getHashIndex("key1");
        map.getHashIndex("key1");
        map.getHashIndex("key2");
        map.getHashIndex("key3");
        map.getHashIndex("key4");
        map.getHashIndex("key5");
        map.getHashIndex("key6");
        map.getHashIndex("key7");
        map.getHashIndex("key8");
        map.getHashIndex("key9");
        map.getHashIndex("key10");
        map.getHashIndex("key11");
        map.getHashIndex("key12");
        map.getHashIndex("key11");
    }
}
