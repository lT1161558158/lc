package top.trister.tree;

import top.trister.tree.struct.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(depth(root.left)-depth(root.right))<2 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode p) {
        return p == null ? 0 : Integer.max(depth(p.left), depth(p.right)) + 1;
    }
}
