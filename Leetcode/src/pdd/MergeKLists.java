package pdd;

public class MergeKLists {
    
    public static class Node {

        public int val;
        Node left;
        Node right;
        public Node next;
        public Node(int val) {this.val = val;}
    }

    public Node mergeKLists(Node[] lists) {

        if(lists.length == 0) {
            return null;
        }
        Node head = null;
        for (Node list : lists) {
            while (list != null) {
                if (head == null) head = list;
                else {
                    putNode(list, head);
                }
                Node tmp = list.next;
                list.next = null;
                list = tmp;
            }
        }

        if(head == null) return head;
        Node res =  traverse(head);
        while(res.left != null) res = res.left;
        return res;
    }

    public void putNode(Node node, Node cur) {

        if(node.val < cur.val) {
            if(cur.left == null) {
                cur.left = node;
            }
            else putNode(node, cur.left);
        }else {
            if(cur.right == null) {
                cur.right = node;
            }
            else putNode(node, cur.right);
        }
    }

    public Node traverse(Node node) {

        if(node.left != null) {
            Node pre = traverse(node.left);
            pre.next = node;
        }else {
            return node;
        }
        if(node.right != null) {
            node.next = traverse(node.right);
        }else {
            return node;
        }
        return node;
    }
}
