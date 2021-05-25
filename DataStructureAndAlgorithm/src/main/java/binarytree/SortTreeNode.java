package binarytree;

/**
 * The node is sorted via {@code num}, left child node less than this node,
 * and right child node great than this node
 *
 * @author ACHENGE
 */
public class SortTreeNode {

    /**
     * This node's number
     */
    int num;

    /**
     * Left child node
     */
    SortTreeNode left;

    /**
     * Right child node
     */
    SortTreeNode right;

    /**
     * Parent node
     */
    SortTreeNode parent;

    /**
     * Constructor with node's number
     * @param num node's number
     */
    public SortTreeNode(int num) {
        this.num = num;
    }

}
