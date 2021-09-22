package pdd;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /**
     * static inner class will extend execution time, may be!
     */
    static class BiLinkedList {

        int key;
        int val;
        BiLinkedList next;
        BiLinkedList pre;

        public BiLinkedList(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final Map<Integer, BiLinkedList> data;

    private final int capacity;

    private BiLinkedList head;

    private BiLinkedList tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>();
    }

    public int get(int key) {

        if(!data.containsKey(key)) return -1;
        BiLinkedList ll = putLast(key);

        return ll.val;
    }

    public void put(int key, int value) {

        if(data.containsKey(key)) {
            BiLinkedList ll = putLast(key);
            ll.val = value;
            return;
        }
        BiLinkedList ll = new BiLinkedList(key, value);
        if(head == null) {
            head = ll;
        }else {
            tail.next = ll;
            ll.pre = tail;
        }
        tail = ll;
        data.put(key, ll);
        if(data.size() > capacity) {
            int headKey = head.key;
            head = head.next;
            head.pre = null;
            data.remove(headKey);
        }
    }

    public BiLinkedList putLast(int key) {

        BiLinkedList ll = data.get(key);
        if(ll.next != null) {
            if(ll == head) {
                head = ll.next;
                ll.next.pre = null;
            }else {
                ll.pre.next = ll.next;
                ll.next.pre = ll.pre;
            }
            tail.next = ll;
            ll.pre = tail;
            ll.next = null;
            tail = ll;
        }

        return ll;
    }
}
