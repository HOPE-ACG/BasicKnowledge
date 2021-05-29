package testDataStructure;

import linked.CircleLinkedList;
import linked.DoubleLinkedList;
import linked.DoubleNode;
import linked.Node;
import org.junit.Test;

public class TestDoubleLinkedList {

    @Test
    public void test(){
        DoubleNode cake = new DoubleNode(777, "DQ");DoubleNode icecream = new DoubleNode(888, "Haagen-dazs");DoubleNode milktea = new DoubleNode(999, "SexyTea");
        DoubleLinkedList linkedList = new DoubleLinkedList();
        //linkedList.allNodes();
        //Test addition
        linkedList.add(cake);linkedList.add(icecream);linkedList.add(milktea);linkedList.allNodes();
        //Test deletion
        linkedList.delete(999);linkedList.allNodes();
        //Test update
        DoubleNode icecream2 = new DoubleNode(888, "Lao Bing Gun");
        linkedList.update(icecream2);linkedList.allNodes();
        //Test addition in sequence
        DoubleNode chocolate = new DoubleNode(666, "Dove");linkedList.addBySequence(chocolate);
        DoubleNode kandy = new DoubleNode(1314, "XU FU JI");linkedList.addBySequence(kandy);linkedList.allNodes();
        //System.out.println(linkedList.getHead().next.next.pre);
    }

    public void testCircle(){
        Node water = new Node(123, "Bai Sui Shan");Node food = new Node(456, "bread");Node health = new Node(789, "sports");
        CircleLinkedList circleLinkedList = new CircleLinkedList(water);
        circleLinkedList.add(food);circleLinkedList.add(health);circleLinkedList.allNodes();
    }

    public void testJosephu(){
        Node car = new Node(1, "Ferrari");Node road = new Node(2, "Lushan South");Node gasoline = new Node(3, "#98");Node driver = new Node(4, "ACG");Node vice_driver = new Node(5, "Yaoyao");
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.add(car);circleLinkedList.add(road);circleLinkedList.add(gasoline);circleLinkedList.add(driver);circleLinkedList.add(vice_driver);
        circleLinkedList.josephu(2, 3);
    }
}
