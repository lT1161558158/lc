package top.trister.tree;

import top.trister.tree.struct.TreeNode;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    public int sumOfLeftLeaves(TreeNode root, boolean left) {
        if (root == null)
            return 0;
        if (left && root.left == null && root.right == null)
            return root.val;
        return sumOfLeftLeaves(root.left,true) + sumOfLeftLeaves(root.right,false);
    }
}
