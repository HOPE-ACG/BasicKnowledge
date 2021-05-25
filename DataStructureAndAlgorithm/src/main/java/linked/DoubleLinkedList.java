package linked;

public class DoubleLinkedList {
    /**
     * Implement methods about addition,deletion and update
     * @para head the head node of this linked list
     */
    private final DoubleNode head;
    public DoubleNode getHead() {
        return head;
    }

    public DoubleLinkedList(){
         this.head = new DoubleNode(0, "");
     }

     //Addition
    public void add(DoubleNode node){
         DoubleNode temp = head;
        //Add this node to last node
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //Deletion
    public void delete(int num){
        DoubleNode temp = head;
        //Find the node via inputted num
        boolean flag = false;
        while(temp.next!=null){
            temp = temp.next;
            if(temp.num==num){
                temp.pre.next = temp.next;
                if(temp.next!=null){
                    temp.next.pre = temp.pre;
                }
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("Does not exist this node");
        }
    }

    //Update
    public void update(DoubleNode node){
        DoubleNode temp = head;
        //Find this node and then update it
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
            System.out.println("Does not exist this node according to this number");
        }
    }

    //Add node in sequence
    public void addBySequence(DoubleNode node){
        DoubleNode temp = head;
        //Add outputted node to linked list in sequence
        boolean flag = false;
        while(temp.next!=null){
            temp = temp.next;
            if(node.num<temp.num){
                temp.pre.next = node;
                node.next = temp;
                node.pre = temp.pre;
                temp.pre = node;
                flag = true;
                break;
            }
        }
        if(!flag){
            temp.next = node;
            node.pre = temp;
        }
    }

    //All nodes
    public void allNodes(){
        DoubleNode temp = head;
        //List all nodes of this linked list
        if(temp.next==null){
            System.out.println("No node in this linked list");
        }
        while(temp.next!=null){
            temp = temp.next;
            System.out.print(temp);
        }
        System.out.println();
    }
}
