package com.maomao.leetcode.solution.solution.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: fujie.feng
 * @DateT: 2019-11-26
 */
public class LRUSolution {

//    public class LRUCache<k, v> extends LinkedHashMap<k, v> {
//
//        //最多能缓存的数据
//        private final int CACHE_SIZE;
//
//        public LRUCache(int cacheSize) {
//            //true 表示让linkedHashMap按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部
//            super((int)Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
//            CACHE_SIZE = cacheSize;
//        }
//
//        @Override
//        protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
//            //当map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据
//            return size() > CACHE_SIZE;
//        }
//    }

//    public static void main(String[] args) {
//        LRUCache<String, String> lruCache = new LRUCache<String, String>(10);
//        for (int i = 0; i < 20; i++) {
//            lruCache.put("a" + i, "a" + i);
//        }
//
//        for (Map.Entry<String, String> entry : lruCache.entrySet()) {
//            System.out.println(entry.getKey() + "===" + entry.getValue());
//        }
//    }

    public class Node {
        private int key;
        private int val;
        private Node prev;
        private Node next;
    }

    public class LRUCache {
        //容量
        private int capacity;

        private Node head;
        private Node last;

        private Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            removeHead(node);
            return node.val;
        }

        private void removeHead(Node node) {
            if (node == head) {
                return;
            }
            if (node == last) {
                last.prev.next = null;
                last = last.prev;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.prev = head.prev;
            node.next = head;

            head.prev = node;
            head = node;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) {
                node = new Node();
                node.key = key;
                node.val = value;

                if (map.size() == capacity) {
                    removeLast();
                }
                addHead(node);
                map.put(key, node);
            } else {
                node.val = value;
                removeHead(node);
            }
        }

        private void addHead(Node node) {
            if (map.isEmpty()) {
                head = node;
                last = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        private void removeLast() {
            map.remove(last.key);
            Node prev = last.prev;
            if (prev != null) {
                prev.next = null;
                last = prev;
            }
        }

        @Override
        public String toString() {
            return map.keySet().toString();
        }
    }

}
