package com.ll.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MyArrayListTests {
    private MyArrayList<String> list;
    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }
    @Test
    @DisplayName("size()")
    void t1(){
        MyArrayList<String> list = new MyArrayList();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("add()")
    void t2() {
        list.add("사과");
        assertThat(list.size()).isEqualTo(1);
    }


    @Test
    @DisplayName("get()")
    void t3() {
        list.add("사과");
        list.add("포도");

        assertThat(list.get(0)).isEqualTo("사과");
        assertThat(list.get(1)).isEqualTo("포도");
    }

    @Test
    @DisplayName("remove()")
    void t4() {
        list.add("사과");
        list.add("포도");

        assertThat(list.remove(0)).isEqualTo("사과");
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("contains()")
    void t5() {
        list.add("사과");
        list.add("포도");
        assertThat(list.contains("사과")).isEqualTo(true);
        assertThat(list.contains("자두")).isEqualTo(false);
    }

    @Test
    @DisplayName("indexOf()")
    void t6() {
        list.add("사과");
        list.add("포도");
        list.add("자두");
        assertThat(0).isEqualTo(list.indexOf("사과"));
        assertThat(1).isEqualTo(list.indexOf("포도"));
        assertThat(2).isEqualTo(list.indexOf("자두"));
    }

    @Test
    @DisplayName("clear()")
    void t7() {
        list.add("사과");
        list.add("포도");
        list.add("자두");
        list.clear();
        assertThat(0).isEqualTo(list.size());
    }

    @Test
    @DisplayName("add(int index, T o)")
    void t8() {
        list.add("사과");
        list.add("포도");
        list.add("자두");
        list.add(1,"메론");

        assertThat(list.get(1)).isEqualTo("메론");
        assertThat(list.get(3)).isEqualTo("자두");
    }

    @Test
    @DisplayName("add(int index, T o)")
    void t9() {
        list.add("사과");
        list.add("포도");
        list.add("자두");
        list.addFirst("메론");

        assertThat(list.get(0)).isEqualTo("메론");
        assertThat(list.get(3)).isEqualTo("자두");
    }











}
