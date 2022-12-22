package com.oop.collections.mylist;

public abstract class MyAbstractList implements  MyList{
    void checkBoundaries (int index, int limit) {
        if (index < 0 || index > limit) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return "MyAbstractList{}";
    }
}
