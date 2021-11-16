package hotsubject;

import java.util.Deque;
import java.util.LinkedList;

public class IsSymmetric {

    public static void main(String[] args) {

        boolean symmetric = new IsSymmetric().isSymmetric(new TreeNode());
        System.out.println(symmetric);

    }

    public boolean isSymmetric(TreeNode root) {

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root.left);
        queue.offerLast(root.right);
        while (!queue.isEmpty()) {
            TreeNode pre = queue.pollLast();
            TreeNode post = queue.pollLast();
            if(pre==null && post==null) continue;
            if((pre==null || post==null) || pre.val!=post.val) return false;
            queue.offerLast(pre.left);
            queue.offerLast(post.right);
            queue.offerLast(pre.right);
            queue.offerLast(post.left);
        }
        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
