package hotsubject;

import java.util.ArrayList;
import java.util.List;

public class TwoNumbersAddition {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(9);
        n2.next = n3;
        ListNode n4 = new ListNode(9);
        n3.next = n4;
        ListNode n5 = new ListNode(9);
        n4.next = n5;
        ListNode n6 = new ListNode(9);
        n5.next = n6;
        ListNode n7 = new ListNode(9);
        n6.next = n7;
        ListNode n8 = new ListNode(9);
        n7.next = n8;
        ListNode n9 = new ListNode(9);
        n8.next = n9;
        ListNode n10 = new ListNode(9);
        n9.next = n10;
        n10.next = new ListNode(9);
        ListNode node = addTwoNumbers(n1, n2);
        List<Integer> result = new ArrayList<>();
        result.add(node.val);
        while(node.next != null) {
            node = node.next;
            result.add(node.val);
        }
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean addOne = false;
        int val = l1.val + l2.val;
        if(val >= 10) {
            val %= 10;
            addOne = true;
        }
        ListNode head = new ListNode(val);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp = head;
        while(temp1.next != null && temp2.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            if(addOne) {
                val = temp1.val + temp2.val + 1;
            }else {
                val = temp1.val + temp2.val;
            }
            if(val >= 10) {
                val %= 10;
                addOne = true;
            }else {
                addOne = false;
            }
            ListNode next = new ListNode(val);
            temp.next = next;
            temp = next;
        }
        while(temp1.next != null) {
            temp1 = temp1.next;
            if(addOne) {
                val = temp1.val + 1;
            }else {
                val = temp1.val;
            }
            if(val >= 10) {
                val %= 10;
                addOne = true;
            }else {
                addOne = false;
            }
            ListNode next = new ListNode(val);
            temp.next = next;
            temp = next;
        }
        while(temp2.next != null) {
            temp2 = temp2.next;
            if(addOne) {
                val = temp2.val + 1;
            }else {
                val = temp2.val;
            }
            if(val >= 10) {
                val %= 10;
                addOne = true;
            }else {
                addOne = false;
            }
            ListNode next = new ListNode(val);
            temp.next = next;
            temp = next;
        }
        if(addOne) {
            temp.next = new ListNode(1);
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
