package binarytree;

/**
 * The BinarySortTree's nodes must be conform to rules, all left child node are less than this node,
 * and all right child node are great than this node
 *
 * @author ACHENGE
 */
public class BinarySortTree {

    /**
     * BinarySortTree's root node
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
    }

    /**
     * Delete certain node of tree. There are three conditions that need to consider
     * @param delNode the number of node that is deleted
     */
    public void del(SortTreeNode delNode) {

        SortTreeNode parentDelNode = delNode.parent;
        if(delNode.left == null && delNode.right == null) {
            if(parentDelNode == null) {
                root = null;
            }else if(parentDelNode.num > delNode.num) {
                parentDelNode.left = null;
            }else {
                parentDelNode.right = null;
            }
        }else if(delNode.left != null && delNode.right != null) {
            maxLeftNodeReplaceDelNode(delNode, parentDelNode);
        }else {
            if(delNode.left == null) {
                SortTreeNode minRightNodeDelNode = delNode.right;
                while(minRightNodeDelNode.left != null) {
                    minRightNodeDelNode = minRightNodeDelNode.left;
                }
                if(delNode.right.left != null) {
                    if(minRightNodeDelNode.right != null){
                        minRightNodeDelNode.parent.left = minRightNodeDelNode.right;
                        minRightNodeDelNode.right.parent = minRightNodeDelNode.parent;
                    }else {
                        minRightNodeDelNode.parent.left = null;
                    }
                    minRightNodeDelNode.right = delNode.right;
                    delNode.right.parent = minRightNodeDelNode;
                }
                minRightNodeDelNode.parent = parentDelNode;
                if(parentDelNode == null) {
                    root = minRightNodeDelNode;
                }else if(parentDelNode.num > delNode.num) {
                    parentDelNode.left = minRightNodeDelNode;
                }else {
                    parentDelNode.right = minRightNodeDelNode;
                }
            }else {
                maxLeftNodeReplaceDelNode(delNode, parentDelNode);
            }
        }
    }

    /**
     * This is a middle method of del method. Using max left node of target node replace target node.
     * @param delNode being deleted node
     * @param parentDelNode parent node of being deleted node
     */
    private void maxLeftNodeReplaceDelNode(SortTreeNode delNode, SortTreeNode parentDelNode) {
        SortTreeNode maxLeftNodeDelNode = delNode.left;
        while(maxLeftNodeDelNode.right != null) {
            maxLeftNodeDelNode = maxLeftNodeDelNode.right;
        }
        if(delNode.left.right != null) {
            if(maxLeftNodeDelNode.left != null) {
                maxLeftNodeDelNode.parent.right = maxLeftNodeDelNode.left;
                maxLeftNodeDelNode.left.parent = maxLeftNodeDelNode.parent;
            }else {
                maxLeftNodeDelNode.parent.right = null;
            }
            maxLeftNodeDelNode.left = delNode.left;
            delNode.left.parent = maxLeftNodeDelNode;
        }
        if(delNode.right != null) {
            maxLeftNodeDelNode.right = delNode.right;
            delNode.right.parent = maxLeftNodeDelNode;
        }
        maxLeftNodeDelNode.parent = parentDelNode;
        if(parentDelNode == null) {
            root = maxLeftNodeDelNode;
        }else if(parentDelNode.num > delNode.num) {
            parentDelNode.left = maxLeftNodeDelNode;
        }else {
            parentDelNode.right = maxLeftNodeDelNode;
        }
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
}

