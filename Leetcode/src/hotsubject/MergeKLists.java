package hotsubject;

import java.util.*;

public class MergeKLists {

    public static void main(String[] args) {
        LListNode l1_1 = new LListNode(1);
        LListNode l1_2 = new LListNode(2);
        LListNode l1_3 = new LListNode(2);
        l1_1.next = l1_2;l1_2.next = l1_3;
        LListNode l2_1 = new LListNode(1);
        LListNode l2_2 = new LListNode(1);
        LListNode l2_3 = new LListNode(2);
        l2_1.next = l2_2;l2_2.next = l2_3;
        LListNode[] lists = new LListNode[]{l1_1, l2_1};
        LListNode listNode = new MergeKLists().mergeKLists(lists);
        do {
            System.out.print(listNode.val + "__");
            listNode = listNode.next;
        } while (listNode != null);
    }

    public LListNode mergeKLists(LListNode[] lists) {

        if(lists.length == 0) {
            return null;
        }
        Map<Integer, Set<LListNode>> map = new TreeMap<>();
        for(LListNode node : lists) {
            if(node == null) {
                continue;
            }
            do {
                Set<LListNode> set = map.getOrDefault(node.val, new HashSet<>());
                set.add(node);
                map.put(node.val, set);
                node = node.next;
            } while(node != null);
        }
        LListNode head = null;
        LListNode temp = null;
        Set<Integer> set = map.keySet();
        for(Integer i : set) {
            Set<LListNode> nodes = map.get(i);
            for(LListNode node : nodes) {
                node.next = null;
                if(head == null) {
                    head = node;
                    temp = node;
                }else {
                    temp.next = node;
                    temp = temp.next;
                }
            }
        }
        return head;
    }
}

class LListNode {
    int val;
    LListNode next;

    LListNode(int val) { this.val = val; }
}
