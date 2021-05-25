package test;

import binarytree.AVLTree;
import binarytree.SortTreeNode;
import org.junit.jupiter.api.Test;

public class testTree {

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
