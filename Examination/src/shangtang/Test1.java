package shangtang;

public class Test1 {

    static class Node {

        int val;
        Node next;
        public Node(int val) {this.val = val;}
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Node tmp = reverse(node1);
        while(tmp != null) {
            System.out.printf("%d\t", tmp.val);
            tmp = tmp.next;
        }
    }

    public static Node reverse(Node head) {

        Node tmp = head;
        int size = 0;
        while(tmp != null) {
            size++;
            tmp = tmp.next;
        }
        int tar = size / 2;
        tmp = head;
        Node cur = null;
        Node af;
        int count = 1;
        while(tmp != null) {
            if(count == tar) {
                af = tmp.next;
                tmp.next = cur;
                head.next = af;
                return tmp;
            }
            if(cur == null) {
                cur = tmp;
                tmp = tmp.next;
            }else {
                af = tmp.next;
                tmp.next = cur;
                cur = tmp;
                tmp = af;
            }
            count++;
        }
        return null;
    }
}
