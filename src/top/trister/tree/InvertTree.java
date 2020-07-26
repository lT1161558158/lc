package top.trister.tree;

import top.trister.tree.struct.TreeNode;

/**
 * Invert a binary tree.
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
