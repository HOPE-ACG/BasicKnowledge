package binarytree;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * The path's length with weight reach to shortest
 */
public class Huffman {

    /**
     * The child's nodes used to construct huffman tree
     */
    private final int[] childNodes;

    /**
     * Constructor with parameter
     * @param childNodes used to construct huffman tree
     */
    public Huffman(int[] childNodes) {
            this.childNodes = childNodes;
    }

    /**
     * Construct huffman tree using number array
     * @return huffman array
     */
    public Node algorithm(){
        Set<Node> nodes = new TreeSet<>();
        for(int num : childNodes){
            Node node = new Node(num);
            nodes.add(node);
        }
        //Iterator<Node> iterator = nodes.iterator();
        while (nodes.size() > 1){
            Iterator<Node> iterator = nodes.iterator();
            Node leftNode = iterator.next();
            Node rightNode = iterator.next();
            Node parentNode = new Node(leftNode.weight + rightNode.weight);
            parentNode.leftNode = leftNode;
            parentNode.rightNode = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
        }
        Iterator<Node> iterator = nodes.iterator();
        return iterator.next();
    }

    /**
     * Nodes of huffman tree
     */
    public static class Node implements Comparable<Node> {

        /**
         * The node's weight
         */
        public int weight;

        /**
         * Left child's node
         */
        public Node leftNode;

        /**
         * Right child's node
         */
        public Node rightNode;

        /**
         * Constructor with parameter
         * @param weight this node's weight
         */
        private Node(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }
}

