package top.trister.tree;

import top.trister.tree.struct.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
