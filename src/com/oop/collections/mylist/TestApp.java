package com.oop.collections.mylist;

import java.util.Arrays;
import java.util.LinkedList;

public class TestApp {
    public static void main(String[] args) {
        MyList l = new MyArrayList();
        l.add("a");
        l.add("b");
        l.add("c");
        System.out.println(l.size());
        System.out.println(l);
        MyList list1 = new MyLinkedList();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        System.out.println(list1.size());
        System.out.println(list1.toString());

        LinkedList linkedList1 = new LinkedList<>();
        linkedList1.add("A");
        linkedList1.add("B");
        linkedList1.add("C");
        System.out.println(linkedList1);

    }
}
