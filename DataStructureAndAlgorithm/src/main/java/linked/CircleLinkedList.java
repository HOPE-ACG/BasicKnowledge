package linked;

import util.AboutNode;

public class CircleLinkedList {
    /**
     * No head node
     */
    private Node first;
    public Node getFirst() {
        return first;
    }

    public CircleLinkedList(){}

    public CircleLinkedList(Node node){
        this.first = node;
        first.next = first;
    }

    //Addition
    public void add(Node node){
        if(first==null){
            this.first = node;
            return;
        }
        Node temp = first;
        while(temp.next!=null){
            if(temp.next==first){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.next = first;
    }

    //All nodes
    public void allNodes(){
        if(first!=null){
            System.out.print(first);
        }
        Node begin = first;
        Node current = first;
        while(current.next!=null){
            current = current.next;
            if(current==begin){
                break;
            }
            System.out.print(current);
        }
        System.out.println();
    }

    //Josephu Circle
    public void josephu(int start, int interval){
        if(this.first==null){
            System.out.print("Null linked list");
            return;
        }
        //Count total nodes
        int count = AboutNode.count(this);
        if(count==1){
            System.out.println(this.first);
            return;
        }
        if(start<1||start>count||interval<1||interval>count){
            System.out.println("Wrong outputted number about start and interval");
            return;
        }
        //Solve JOSEPHU QUESTION
        Node front = this.first;
        Node current = this.first.next;
        if(start==1){
            current = this.first;
        }
        for(int i=2;i<start;i++){
            front = front.next;
            current = current.next;
        }
        if(front==current){
            for(int j=1;j<interval;j++){
                current = current.next;
                if(j!=1){
                    front = front.next;
                }
            }
            System.out.println(current);
            if(interval!=1){
                front.next = current.next;
                current.next = null;
            }
            current = front.next;
        }
        while(front!=current){
            for(int j=1;j<interval;j++){
                current = current.next;
                front = front.next;
            }
            System.out.println(current);
            front.next = current.next;
            current.next = null;
            current = front.next;
        }
        if(start!=1){
            System.out.println(current);
        }
    }
}
