package com.maomao.leetcode.solution.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fujie.feng
 * @Date 2020-04-05
 */
public class LFUCache {
    /**
     * 缓存节点
     */
    private Map<Integer, Node> cache;

    /**
     * 频次最大的双向链表
     */
    private DoublyLinkedList firstLinkedList;

    /**
     * 频次最低的双向链表
     * 满了之后就删除lastLinkedList.pre.tail.pre 这个node即为频次最小且访问最早的node
     */
    private DoublyLinkedList lastLinkedList;

    /**
     * 当前缓存大小
     */
    private int size;

    /**
     * 容量
     */
    private int capacity;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        firstLinkedList = new DoublyLinkedList();
        lastLinkedList = new DoublyLinkedList();
        firstLinkedList.next = lastLinkedList;
        lastLinkedList.pre = firstLinkedList;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //访问频率加1
        frepInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            frepInc(node);
        } else {
            //缓存满了，删除一个访问频率最低的
            if (size == capacity) {
                cache.remove(lastLinkedList.pre.tail.pre.key);
                lastLinkedList.removeNode(lastLinkedList.pre.tail.pre);
                size--;
                if (lastLinkedList.pre.head.next == lastLinkedList.pre.tail) {
                    removeDoublyLinkedList(lastLinkedList.pre);
                }
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            if (lastLinkedList.pre.frep != 1) {
                DoublyLinkedList newDoublyLinkedList = new DoublyLinkedList(1);
                addDoublyLinkedList(newDoublyLinkedList, lastLinkedList.pre);
                newDoublyLinkedList.addNode(newNode);
            } else {
                lastLinkedList.pre.addNode(newNode);
            }
            size++;
        }
    }

    private void frepInc(Node node) {
        DoublyLinkedList doublyLinkedList = node.doublyLinkedList;
        DoublyLinkedList preLinkedList = doublyLinkedList.pre;
        doublyLinkedList.removeNode(node);
        if (doublyLinkedList.head.next == doublyLinkedList.tail) {
            removeDoublyLinkedList(doublyLinkedList);
        }
        node.frep++;
        if (preLinkedList.frep != node.frep) {
            DoublyLinkedList newDoublyLinkedList = new DoublyLinkedList(node.frep);
            addDoublyLinkedList(newDoublyLinkedList, preLinkedList);
            newDoublyLinkedList.addNode(node);
        } else {
            preLinkedList.addNode(node);
        }
    }

    private void addDoublyLinkedList(DoublyLinkedList newDoublyLinkedList, DoublyLinkedList preDoublyLinkedList) {
        newDoublyLinkedList.next = preDoublyLinkedList.next;
        newDoublyLinkedList.next.pre = newDoublyLinkedList;
        newDoublyLinkedList.pre = preDoublyLinkedList;
        preDoublyLinkedList.next = newDoublyLinkedList;
    }

    private void removeDoublyLinkedList(DoublyLinkedList doublyLinkedList) {
        doublyLinkedList.pre.next = doublyLinkedList.next;
        doublyLinkedList.next.pre = doublyLinkedList.pre;
    }


    class Node {
        private int key;

        private int value;

        private int frep = 1;

        private Node pre;

        private Node next;

        /**
         * node所在频次的双向链表
         */
        DoublyLinkedList doublyLinkedList;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 新增节点从头部开始新增
     * 删除从尾部开始删除
     */
    class DoublyLinkedList {
        private int frep;

        private DoublyLinkedList pre;

        private DoublyLinkedList next;

        /**
         * 双向链表头，表示最近访问
         */
        private Node head;

        /**
         * 双向链表尾，表示最久访问
         */
        private Node tail;

        public DoublyLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            head.pre = head;
        }

        public DoublyLinkedList(int frep) {
            head = new Node();
            tail = new Node();

            head.next = tail;
            tail.pre = head;
            this.frep = frep;
        }

        /**
         * 新增节点
         * @param node
         */
        public void addNode(Node node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
            node.doublyLinkedList = this;
        }

        /**
         * 删除节点
         * @param node
         */
        public void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

    }
}
