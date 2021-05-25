package testDataStructure;

import linked.Node;
import linked.SingleLinkedList;
import util.AboutNode;

public class TestSingleLinkedList {

    public static void main(String[] args){
        //Create nodes{
        Node computer = new Node(5, "ASUS");Node person = new Node(8, "ACG");Node time = new Node(3, "buy computer");
        //Add nodes
        SingleLinkedList link = new SingleLinkedList();
        link.addLast(computer);link.addLast(person);link.addLast(time);link.allNode();
        //Add nodes by sequence
        Node bike = new Node(55, "forever");Node water = new Node(66, "sexytea");Node desert = new Node(3, "takalamagan");Node price = new Node(9, "Amazing");
        SingleLinkedList sequentialLink = new SingleLinkedList();
        sequentialLink.addBySequence(bike);sequentialLink.addBySequence(water);sequentialLink.addBySequence(desert);sequentialLink.addBySequence(price);sequentialLink.allNode();
        //Delete node
        sequentialLink.deleteById(66);sequentialLink.allNode();
        sequentialLink.deleteById(789);
        //Update node
        Node game = new Node(3, "Counter-Strike");link.update(game);link.allNode();
        Node game2 = new Node(22, "League of Legends");link.update(game2);
        //Count nodes
        int nodes = link.countNode(link);
        int nodes2 = sequentialLink.countNode(sequentialLink);
        System.out.printf("link节点数%d,sequentiallink节点数%d", nodes, nodes2);
        System.out.println();
        //Find the node by counting backwards
        Node result = link.check(2);
        System.out.println(result);
        Node result2 = sequentialLink.check(3);
        System.out.println(result2);
        //Reverse single linked list
        link.reverse();link.allNode();
        //sequentialLink.reverse();sequentialLink.allNode();
        //Reversely output linked list
        link.output();//sequentialLink.output();
        //Combine two sequential linked list
        Node pig = new Node(3, "peggy");Node tiger = new Node(78, "shengongbao");Node cat = new Node(99, "kity");
        SingleLinkedList sequentialLink2 = new SingleLinkedList();
        sequentialLink2.addBySequence(pig);sequentialLink2.addBySequence(tiger);sequentialLink2.addBySequence(cat);
        sequentialLink2.allNode();
        SingleLinkedList sequentialLink3 = AboutNode.combine(sequentialLink, sequentialLink2);
        sequentialLink3.allNode();
    }
}
