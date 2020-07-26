package top.trister.tree;

import top.trister.tree.struct.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumDepth {
    //要注意只有左子树或者右子树的情况
    public int minDepth(TreeNode root) {
        if (root==null)
            return 0;
        int leftDepth=minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left==null || root.right==null)
            return leftDepth+rightDepth+1;
        return 1+Integer.min(leftDepth,rightDepth);
    }
}
