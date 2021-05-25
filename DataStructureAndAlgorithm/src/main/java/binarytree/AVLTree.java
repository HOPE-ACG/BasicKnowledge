package binarytree;

/**
 * The left child tree and right child tree of height difference of any nodes of tree
 * must be less than one
 *
 * @author ACHENGE
 */
public class AVLTree {

    /**
     * AVLTree's root node
     */
    private SortTreeNode root;

    public SortTreeNode getRoot() {
        return root;
    }

    /**
     * Add node to tree vid comparing to node's number
     * @param addedNode being added node
     */
    public void add(SortTreeNode addedNode) {

        if(root == null) {
            root = addedNode;
            return;
        }
        SortTreeNode temp = root;
        while(true) {
            if(temp.num > addedNode.num && temp.left != null) {
                temp = temp.left;
            }else if(temp.num <= addedNode.num && temp.right != null) {
                temp = temp.right;
            }else if(temp.num > addedNode.num) {
                temp.left = addedNode;
                addedNode.parent = temp;
                break;
            }else {
                temp.right = addedNode;
                addedNode.parent = temp;
                break;
            }
        }
        judgeAndMove();
    }

    /**
     * Traverse whole tree via infix form
     */
    public void infix() {

        traversalRecursionViaInfix(root);
        System.out.println();
    }

    /**
     * Recursive method that is used by traversal in infix
     * @param begin the beginning node that is traversed
     */
    private void traversalRecursionViaInfix(SortTreeNode begin) {

        System.out.print(begin.num + " ");
        if(begin.left != null) {
            traversalRecursionViaInfix(begin.left);
        }
        if(begin.right != null) {
            traversalRecursionViaInfix(begin.right);
        }
    }

    /**
     * Trigger this method only just when the height of right child tree greater than
     * the height of left child tree adding one.
     *
     * @param node the parent node of tree that need to be rotated
     */
    public void rotateToLeft(SortTreeNode node) {

        SortTreeNode copyRoot = new SortTreeNode(node.num);
        copyRoot.left = node.left;
        copyRoot.right = (node.right.left == null? null : node.right.left);
        node.num = node.right.num;
        node.right = node.right.right;
        node.left = copyRoot;
    }

    /**
     * Trigger this method only just when the height of left child tree greater than
     * the height of right child tree adding one.
     *
     * @param node the parent node of tree that need to be rotated
     */
    public void rotateToRight(SortTreeNode node) {

        SortTreeNode copyRoot = new SortTreeNode(node.num);
        copyRoot.right = node.right;
        copyRoot.left = (node.left.right == null? null : node.left.right);
        node.num = node.left.num;
        node.left = node.left.left;
        node.right = copyRoot;
    }

    /**
     * Calculate the height of whole tree
     * @param node calculating the height of tree from this node
     */

    private int heightOfThisTree(SortTreeNode node) {

        if(node != null) {
            return Math.max(
                    (node.left == null? 0 : heightOfThisTree(node.left)) + 1,
                    (node.right == null? 0 : heightOfThisTree(node.right)) + 1
            ) + 1;
        }else {
            return 0;
        }
    }

    /**
     * Judge the height difference of left child tree and right child tree of root,
     * and then rotating or remaining
     */
    private void judgeAndMove() {

        int left = heightOfThisTree(root.left);
        int right = heightOfThisTree(root.right);
        if(left - right > 1) {
            int leftChildTreeLeft = heightOfThisTree(root.left.left);
            int leftChildTreeRight = heightOfThisTree(root.left.right);
            if(leftChildTreeRight - leftChildTreeLeft > 0) {
                rotateToLeft(root.left);
            }
            rotateToRight(root);
        }else if(right - left > 1) {
            int rightChildTreeLeft = heightOfThisTree(root.right.left);
            int rightChildTreeRight = heightOfThisTree(root.right.right);
            if(rightChildTreeLeft - rightChildTreeRight > 0) {
                rotateToRight(root.right);
            }
            rotateToLeft(root);
        }
    }
}
