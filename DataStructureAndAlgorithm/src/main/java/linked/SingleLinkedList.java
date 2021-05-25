package linked;

import java.util.Stack;

public class SingleLinkedList {
    /**
     *Implement methods of addition,deletion and update
     * @para head The first node
     */
    private final Node head = new Node(0, "");
    public Node getHead() {
        return head;
    }

    public void addLast(Node node){
        //Temporarily replace the head node
        Node temp = head;
        while (true){
            if(temp.next==null){
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    public void addBySequence(Node node){
        //Temporarily replace the head node
        Node temp = head;
        while(true){
            if(temp.next!=null) {
                if (temp.next.num > node.num) {
                    node.next = temp.next;
                    temp.next = node;
                    break;
                }
            }else{
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    public void deleteById(int id){
        Node temp = this.head;
        boolean flag = false;
        while(temp.next!=null){
            if(temp.next.num==id){
                if(temp.next.next!=null){
                    temp.next = temp.next.next;
                }else {
                    temp.next = null;
                }
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(!flag){
            System.out.println("Does not exist this node");
        }
    }

    public void update(Node node){
        Node temp = this.head;
        boolean flag = false;
        while(temp.next!=null){
            temp = temp.next;
            if(temp.num==node.num){
                temp.name = node.name;
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("Wrong num info about this node");
        }
    }

    //Count nodes in linked list
    public int countNode(SingleLinkedList linkedList){
        Node temp = linkedList.head;
        int length = 0;
        while (temp.next != null) {
            length += 1;
            temp = temp.next;
        }
        return length;
    }

    //Look up k node by counting backwards
    public Node check(int k){
        int length = this.countNode(this);
        if(k>length || k<1){
            return null;
        }
        int location = length-k+1;
        int count = 0;
        Node temp = this.head;
        while (count<location){
            temp = temp.next;
            count++;
        }
        return temp;
    }

    //Reverse single linked list
    public void reverse(){
        Node head = this.head;
        if(head.next!=null && head.next.next!=null){
            //Point to node currently
            Node temp = head.next.next;
            //The one before this node
            Node front = head.next;
            //The one behind this node
            Node back = head.next.next.next;
            head.next.next = null;
            while(temp!=null){
                head.next = temp;
                temp.next = front;
                front = temp;
                temp = back;
                if(back!=null && back.next!=null){
                    back = back.next;
                }else{
                    back = null;
                }
            }
        }
    }

    //Output linked list reversely
    public void output(){
        Node temp = this.head;
        Stack<Node> stack = new Stack<>();
        while(temp.next!=null){
            temp = temp.next;
            stack.push(temp);
        }
        while(!stack.empty()){
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    //Delete first node after head node
    public void delete(){
        Node temp = this.head;
        if(temp.next!=null){
            temp = temp.next;
            if(temp.next!=null){
                temp = temp.next;
                this.head.next = temp;
            }else {
                this.head.next = null;
            }
        }
    }

    public void allNode(){
        //Temporarily replace the head node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.print(temp);
        }
        System.out.println();
    }
}

