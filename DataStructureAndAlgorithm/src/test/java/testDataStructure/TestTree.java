package testDataStructure;

import binarytree.*;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestTree {

    public void testHash(){
        Hashtable_acg hashtable_acg = new Hashtable_acg(10);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Please type: ADD/DEL/PRE/EXIT---");
            String input = scanner.next();
            switch (input) {
                case "ADD":
                    System.out.print("Please type employee's id:");
                    int id = scanner.nextInt();
                    System.out.print("Please type employee's name:");
                    String name = scanner.next();
                    System.out.print("Please type employee's age:");
                    int age = scanner.nextInt();
                    System.out.print("Please type employee's phone:");
                    String phone = scanner.next();
                    hashtable_acg.add(new Hashtable_acg.Employee(id, name, age, phone));
                    break;
                case "DEL":
                    System.out.print("Please type employee's id:");
                    id = Integer.parseInt(scanner.next());
                    if(hashtable_acg.delete(id)) {
                        System.out.println("Had been deleted");
                    }
                    break;
                case "PRE":
                    hashtable_acg.present();
                    break;
                case "EXIT":
                    System.out.println("Bye");
                    return;
                default:
                    System.out.println("Type wrong");
                    break;
            }
        }
    }

    public void testBinaryTree() {
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node node = new BinaryTree.Node(5, "ACG");
        tree.add(node);
        BinaryTree.Node node1 = new BinaryTree.Node(3, "Yao");
        tree.add(node1);
        BinaryTree.Node node2 = new BinaryTree.Node(8, "Guo");
        tree.add(node2);
        BinaryTree.Node node3 = new BinaryTree.Node(8, "Hu");
        tree.add(node3);
        BinaryTree.Node node4 = new BinaryTree.Node(1, "Fan");
        tree.add(node4);
        BinaryTree.Node node5 = new BinaryTree.Node(15, "Lin");
        tree.add(node5);
        BinaryTree.Node node6 = new BinaryTree.Node(4, "Li");
        tree.add(node6);
        //tree.preorder_traversal(); //5,3,1,8(Guo),8(Hu)
        //tree.inorder_traversal(); //1,3,5,8(Hu),8(Guo)
        tree.postorder_traversal(); //1,3,8(Hu),8(Guo),5
        BinaryTree.Node target = tree.search(15).getRight();
        System.out.println("Target:"+target);
        //tree.delete(8);
        //tree.delete(3);
        //tree.postorder_traversal();
        tree.preorderClue();
        BinaryTree.Node nodeWithClue = tree.search(1).getLeft();
        System.out.println(nodeWithClue);
        System.out.println("previous node:"+nodeWithClue.getLeft()+"rear node:"+nodeWithClue.getRight());
    }

    public void testBigPeakHeap(){
        //int[] nums = {5, 8, 9, 2, 3, 45, 22, 13, 88};
        int[] nums = new int[80000000];
        for(int i=0;i<nums.length;i++){
            nums[i] = (int)(Math.random()*8000);
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss SSS");
        System.out.println(format.format(new Date()));
        HeapSort heapSort = new HeapSort(nums);
        heapSort.bigPeakHeap();
        System.out.println(format.format(new Date()));
    }

    public void huffman(){

        int[] seq = new int[]{13, 7, 8, 3, 29, 6, 1};
        Huffman huffman = new Huffman(seq);
        Huffman.Node huffmanTree = huffman.algorithm();
        if(huffmanTree != null){
            recursion(huffmanTree);
        }
    }

    private void recursion(Huffman.Node node) {
        System.out.print(node.weight + " ");
        if(node.leftNode != null) {
            recursion(node.leftNode);
        }
        if(node.rightNode != null) {
            recursion(node.rightNode);
        }
    }

    public void testBinarySortTree() {
        SortTreeNode n1 = new SortTreeNode(50);
        SortTreeNode n2 = new SortTreeNode(30);
        SortTreeNode n3 = new SortTreeNode(20);
        SortTreeNode n4 = new SortTreeNode(10);
        SortTreeNode n5 = new SortTreeNode(17);
        SortTreeNode n6 = new SortTreeNode(25);
        SortTreeNode n7 = new SortTreeNode(29);
        SortTreeNode n8 = new SortTreeNode(26);
        SortTreeNode n9 = new SortTreeNode(40);
        SortTreeNode n10 = new SortTreeNode(38);
        SortTreeNode n11 = new SortTreeNode(48);
        SortTreeNode n12 = new SortTreeNode(45);
        SortTreeNode n13 = new SortTreeNode(43);
        SortTreeNode n14 = new SortTreeNode(44);
        SortTreeNode n15 = new SortTreeNode(90);
        SortTreeNode n16 = new SortTreeNode(70);
        SortTreeNode n17 = new SortTreeNode(100);
        SortTreeNode n18 = new SortTreeNode(98);
        SortTreeNode n19 = new SortTreeNode(96);
        SortTreeNode n20 = new SortTreeNode(120);
        SortTreeNode n21 = new SortTreeNode(27);
        SortTreeNode n22 = new SortTreeNode(36);

        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.add(n1);
        binarySortTree.add(n2);
        binarySortTree.add(n3);
        binarySortTree.add(n4);
        binarySortTree.add(n5);
        binarySortTree.add(n6);
        binarySortTree.add(n7);
        binarySortTree.add(n8);
        binarySortTree.add(n9);
        binarySortTree.add(n10);
        binarySortTree.add(n11);
        binarySortTree.add(n12);
        binarySortTree.add(n13);
        binarySortTree.add(n14);
        binarySortTree.add(n15);
        binarySortTree.add(n16);
        binarySortTree.add(n17);
        binarySortTree.add(n18);
        binarySortTree.add(n19);
        binarySortTree.add(n20);
        binarySortTree.add(n21);
        binarySortTree.add(n22);

        binarySortTree.infix();
        binarySortTree.del(n6); //25
        binarySortTree.infix();
        binarySortTree.del(n3); //20
        binarySortTree.infix();
        binarySortTree.del(n9); //40
        binarySortTree.infix();
        binarySortTree.del(n11); //48
        binarySortTree.infix();
        binarySortTree.del(n17); //100
        binarySortTree.infix();
    }

    @Test
    public void testAVL() {

        SortTreeNode dog = new SortTreeNode(25);
        SortTreeNode cat = new SortTreeNode(10);
        SortTreeNode taiger = new SortTreeNode(50);
        SortTreeNode panda = new SortTreeNode(30);
        SortTreeNode mouse = new SortTreeNode(70);
        SortTreeNode snake = new SortTreeNode(28);
        SortTreeNode lion = new SortTreeNode(45);

        AVLTree animal = new AVLTree();
        animal.add(dog);
        animal.add(cat);
        animal.add(taiger);
        animal.add(panda);
        animal.add(mouse);
        animal.add(snake);
        animal.add(lion);
        animal.infix();
    }
}
