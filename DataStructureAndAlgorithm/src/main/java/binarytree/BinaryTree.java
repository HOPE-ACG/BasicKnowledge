package binarytree;

import java.util.NoSuchElementException;

/**
 * binary tree
 *
 * @author ACHENGE
 */
public class BinaryTree {

    /**
     * The head node of BinaryTree
     */
    private Node head;

    /**
     * The previous node of current node
     */
    private Node pre;

    /**
     * Add node to BinaryTree according to rules
     * @param node be inputted
     */
    public void add(Node node) {
        if(head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while(true) {
            if(node.id > temp.id) {
                if(temp.right == null){
                    temp.right = node;
                    break;
                }else {
                    temp = temp.right;
                }
            }else {
                if(temp.left == null) {
                    temp.left = node;
                    break;
                }else {
                    temp = temp.left;
                }
            }
        }
    }

    /**
     * Delete node by id,if the node that will be deleted is head node,deleting
     * whole binary tree
     * @param id the node's id
     */
    public void delete(int id){
        Node target = search(id);
        if(target == null){
            throw new NoSuchElementException("No this node in binary tree");
        }
        if(id == head.id){
            head = null;
            return;
        }
        Node temp;
        Node temp2;
        if(target.left.id == id){
            if(target.left.left != null){
                if(target.left.right == null){
                    target.left = target.left.left;
                    return;
                }else {
                    temp = target.left.right;
                    target.left = target.left.left;
                    if(target.left.right == null){
                        target.left.right = temp;
                    }else {
                        temp2 = temp;
                        while(temp2.left != null){
                            temp2 = temp2.left;
                        }
                        temp2.left = target.right;
                        target.right = temp;
                    }
                }
            }
            if(target.left.right != null){
                target.left = target.left.right;
            }
        }else {
            if(target.right.left != null){
                if(target.right.right == null){
                    target.right = target.right.left;
                    return;
                }else {
                    temp = target.right.right;
                    target.right = target.right.left;
                    if(target.right.right == null){
                        target.right.right = temp;
                    }else {
                        temp2 = temp;
                        while(temp2.left != null){
                            temp2 = temp2.left;
                        }
                        temp2.left = target.right.right;
                        target.right.right = temp;
                    }
                }
            }
            if(target.right.right != null){
                target.right = target.right.right;
            }
        }
    }

    /**
     * Search node by id,if {@code id} is matched with head node's id or
     * child node's id of head node,returning head node only
     * @param id the node's id
     * @return the father's node that is matched with {@para id}
     */
    public Node search(int id){
        if(head == null){
            throw new NullPointerException("Head node is null");
        }
        if(head.id == id){
            return head;
        }
        Node temp = head;
        while(true){
            if(temp.left != null && temp.left.id == id ||
                    temp.right != null && temp.right.id == id){
                return temp;
            }
            if(id > temp.id && temp.right != null){
                temp = temp.right;
                continue;
            }
            if(id > temp.id){
                return null;
            }
            if(id < temp.id && temp.left != null){
                temp = temp.left;
                continue;
            }
            if(id < temp.id){
                return null;
            }
        }
    }

    /**
     * Output node info by recursion algorithm
     * @param node current node
     * @param mode 1 represents preorder;2 represents inorder;3 represents postorder
     */
    private void recursion(Node node, int mode) {
        if(mode == 1){
            System.out.println(node.toString());
        }
        if(node.left != null) {
            recursion(node.left, mode);
        }
        if(mode == 2) {
            System.out.println(node.toString());
        }
        if(node.right != null) {
            recursion(node.right, mode);
        }
        if(mode == 3) {
            System.out.println(node.toString());
        }
    }

    /**
     * Travel binary tree by preorder calculation
     */
    public void preorder_traversal() {
        if(head == null) {
            throw new NullPointerException("Head node is null");
        }
        Node temp = head;
        recursion(temp, 1);
    }

    /**
     * Travel binary tree by inorder calculation
     */
    public void inorder_traversal() {
        if(head == null) {
            throw new NullPointerException("Head node is null");
        }
        Node temp = head;
        recursion(temp, 2);
    }

    /**
     * Travel binary tree by postorder calculation
     */
    public void postorder_traversal() {
        if(head == null) {
            throw new NullPointerException("Head node is null");
        }
        Node temp = head;
        recursion(temp, 3);
    }


    /**
     * Utilize node's null pointer,pointing previous or rear node
     */
    public void preorderClue() {
        if(head == null){
            throw new NullPointerException("Head node is null");
        }
        Node temp = head;
        recursion(temp);
    }

    /**
     * Recurse binary tree in preorder way and add clue
     * @param cur current node
     */
    private void recursion(Node cur){
        if(cur.left != null){
            pre = cur;
            recursion(cur.left);
        }
        if(cur.left == null){
            cur.left = pre;
            pre = cur;
        }
        if(cur.right != null){
            if(pre.right == null){
                pre.right = cur.right;
            }
            cur = cur.right;
            recursion(cur);
        }
    }

    /**
     * Get numbers of binary tree's node
     * @return node's counts
     */
    public int getLength(){
        if(head == null){
            return 0;
        }
        Node temp = head;
        return recursion_length(temp, 1);
    }

    private static int recursion_length(Node node, int length){
        int l = length;
        if(node.left != null){
            l = recursion_length(node.left, l + 1);
        }
        if(node.right != null){
            l = recursion_length(node.right, l + 1);
        }
        return l;
    }

    /**
     * Changing Binary Tree to array's form
     * @return array form of tree
     */
    public Object[] treeToArray(){
        int length = getLength();
        Object[] nodes = new Object[length];
        if(length > 0){
            nodes[0] = head;
        }else {
            throw new NullPointerException("Head node is null");
        }
        Node temp = head;
        recursion(nodes, 0, temp);
        return nodes;
    }

    /**
     * Travel binary tree, meanwhile inserting node to array
     * @param nodes {@code nodes}
     * @param pos the position that this node should lie in array
     * @param node current node
     */
    private static void recursion(Object[] nodes, int pos, Node node){
        if(node.left != null){
            nodes[2 * pos + 1] = node.left;
            recursion(nodes, 2 * pos + 1, node.left);
        }
        if(node.right != null){
            nodes[2 * pos + 2] = node.right;
            recursion(nodes, 2 * pos + 2, node.right);
        }
    }

    /**
     * Define a entity node
     */
    public static class Node {

        /**
         * Node's number
         */
        private final int id;

        /**
         * Node's name
         */
        private final String name;

        /**
         * Left node of this node
         */
        private Node left;

        /**
         * Right node of this node
         */
        private Node right;

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        /**
         * Node's constructor
         * @param id {@code id} number
         * @param name {@code name} of this node
         */
        public Node(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}

