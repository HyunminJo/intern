package kr.co.crewmate.ojt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import kr.co.crewmate.ojt.start.MyArrayList;

public class MyArrayListTest {
    MyArrayList<String> list = new MyArrayList<String>();
    @Test
    public void testAdd() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        assertEquals(1, list.size());
    }
    
    @Test
    public void testAddAll() { 
        list = new MyArrayList<String>();
        list.addAll(list);
        assertEquals(2, list.size());
    }
    
    @Test
    public void testRemove() {
        MyArrayList<String> list = new MyArrayList<String>();
        list.remove("A");
        assertEquals(1, list.size());
    }
    
}
