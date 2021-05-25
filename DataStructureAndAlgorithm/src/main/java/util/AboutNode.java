package util;

import linked.CircleLinkedList;
import linked.Node;
import linked.SingleLinkedList;


public class AboutNode {
    //Combine two sequential single linked list
    public static SingleLinkedList combine(SingleLinkedList list1, SingleLinkedList list2){
        //The SingleLinkedList after combining
        SingleLinkedList list = new SingleLinkedList();
        //Can't change head node
        Node temp1 = list1.getHead();
        //Output all nodes in two linked lists,meanwhile insert smaller node before bigger node
        if(temp1.next!=null){
            temp1 = temp1.next;
            list.addLast(temp1);
        }
        while(list2.getHead().next!=null){
            Node temp2 = list2.getHead().next;
            list2.delete();
            temp2.next = null;
            list.addBySequence(temp2);
        }
        return list;
    }

    //Calculate total nodes of CircleLinkedList
    public static int count(CircleLinkedList linkedList) {
        Node first = linkedList.getFirst();
        //Count total nodes
        int count = 0;
        if (first == null) {
            System.out.print("Null linked list");
            return 0;
        }
        Node current = first;
        while (current.next != null) {
            current = current.next;
            if (current == first) {
                count++;
                break;
            }
            count++;
        }
        return  count;
    }
}
