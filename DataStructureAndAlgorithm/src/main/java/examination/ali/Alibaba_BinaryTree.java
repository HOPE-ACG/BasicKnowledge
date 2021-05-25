package examination.ali;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Alibaba_BinaryTree {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] strs = s.split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);
        String number = br.readLine();
        String[] numbers = number.split(" ");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }
        Node root = new Node(nums[0]);
        for(int i = 1; i < n; i++) {
            root.add(new Node(nums[i]));
        }
        int height = calHeight(root);
        Map<Integer, List<Node>> layerNodes = new HashMap<>();
        List<Node> firstLayerNodes = new ArrayList<>();
        firstLayerNodes.add(root);
        layerNodes.put(1, firstLayerNodes);
        for(int i = 2; i <= height; i++) {
            List<Node> preLayerNodes = layerNodes.get(i - 1);
            List<Node> curLayerNodes = layerTraversal(preLayerNodes);
            layerNodes.put(i, curLayerNodes);
        }
        Set<Integer> keys = layerNodes.keySet();
        for(Integer layer : keys) {
            if(layer == 1) {
                continue;
            }
            List<Node> curLayerNodes = layerNodes.get(layer);
            Object[] afterMoveLayerNodes = move(curLayerNodes, k);
            int index = 0;
            for (Node curNode : curLayerNodes) {
                Node aftNode = (Node)afterMoveLayerNodes[index];
                curNode.num = aftNode.num;
                index++;
            }
        }
        infix(root);
    }

    public static int calHeight(Node begin) {

        if(begin == null) {
            return 0;
        }
        return Math.max(calHeight(begin.left) + 1, calHeight(begin.right) + 1);
    }

    public static List<Node> layerTraversal(List<Node> nodes) {

        List<Node> res = new ArrayList<>();
        for(Node n : nodes) {
            if(n.left != null) {
                res.add(n.left);
            }
            if(n.right != null) {
                res.add(n.right);
            }
        }
        return res;
    }

    public static void infix(Node root) {

        System.out.print(root.num + " ");
        if(root.left != null) {
            infix(root.left);
        }
        if(root.right != null) {
            infix(root.right);
        }
    }

    public static Object[] move(List<Node> nodes, int k) {

        int size = nodes.size();
        Object[] afterMoveLayerNodes = new Object[size];
        int realMoveTime = k % size;
        for(int i = 0; i < size; i++) {
            Node node = new Node(nodes.get(i).num);
            int pos = i - realMoveTime;
            if(i < realMoveTime) {
                pos = size - (realMoveTime - i);
            }
            afterMoveLayerNodes[pos] = node;
        }
        return afterMoveLayerNodes;
    }
}

class Node {

    int num;
    Node left;
    Node right;
    public Node(int num) {
        this.num = num;
    }

    public void add(Node node) {
        if(this.num > node.num) {
            if(this.left == null) {
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right == null) {
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }
}
