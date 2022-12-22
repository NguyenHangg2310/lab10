package com.oop.collections.mymap;

import java.util.Arrays;

public class MyHashMap implements MyMap {
    MyHashMapEntry[] table;
    final static int INITIAL_SIZE = 8;
    int size = 0;

    public MyHashMap() {
        table = new MyHashMapEntry[INITIAL_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    public double capacityRatio() {
        return size / (double) table.length;
    }

    @Override
    public void remove(Object key) {
        int bucket = getBucket(key);
        if (table[bucket] != null) {
            table[bucket] = null;
            size--;
        }
    }

    public void enlarge() {
        table = Arrays.copyOf(table, table.length * 2);
    }

    @Override
    public boolean contains(Object key) {
        return table[getBucket(key)] != null;
    }

    public Object get(Object key) {
        int bucket = getBucket(key);
        if (table[bucket] != null) {
            return table[bucket].getValue();
        }
        return -1;
    }

    public int getBucket(Object key) {
        int bucket = Math.abs(key.hashCode()) % table.length;
        while (table[bucket] != null && table[bucket].getKey() != key) {
            bucket = (bucket + 1) % table.length;
        }
        return bucket;
    }

    public void put(Object key, Object value) {
        if (capacityRatio() > 0.6) {
            enlarge();
        }
        int bucket = getBucket(key);
        if (table[bucket] == null) {
            table[bucket] = new MyHashMapEntry(key, value);
            size++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                sb.append(String.format("[bucket %d] -> null\n", i ));
            }else {
                sb.append(String.format("[bucket %d] -> (%s, %s)\n", i, table[i].getKey(), table[i].getValue()));
            }
        }
        return sb.toString();
    }


}
