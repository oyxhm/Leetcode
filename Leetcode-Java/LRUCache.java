import java.util.HashMap;
import java.util.Map;

/**
 * Created by yhf on 15/6/29.
 */

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations:
get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
should invalidate the least recently used item before inserting a new item.
*/


class DoubleListNode {
    int val;
    int key;
    DoubleListNode prev, next;
    DoubleListNode(int k, int v) {
        key = k;
        val = v;
        prev = null;
        next = null;
    }
}

public class LRUCache {

    private int count, capacity;
    private DoubleListNode head, tail;
    private Map<Integer, DoubleListNode> map;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new DoubleListNode(0, 0);
        this.tail = new DoubleListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void detach(DoubleListNode node) {
        // detach node from list
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void attach(DoubleListNode node) {
        // attach node to the head of list
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleListNode node = map.get(key);
            detach(node);
            attach(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleListNode node = map.get(key);
            node.val = value;
            detach(node);
            attach(node);
        } else {
            DoubleListNode node = new DoubleListNode(key, value);
            attach(node);
            map.put(key, node);
            if (count < capacity) {
                count++;
            } else {
                map.remove(tail.prev.key);
                detach(tail.prev);
            }
        }
    }
}
