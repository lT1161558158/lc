package top.trister.tree;

import top.trister.tree.struct.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        //中序遍历(morris搜索)找到最近值
        AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
        Consumer<TreeNode> consumer = new Consumer<TreeNode>() {
            TreeNode prev = null;

            @Override
            public void accept(TreeNode node) {
                if (prev != null) {
                    min.set(Math.min(Math.abs(node.val - prev.val), min.get()));
                }
                prev = node;
            }
        };
        inOrder(root, consumer);
        return min.get();
    }

    void inOrder(TreeNode node, Consumer<TreeNode> action) {
        if (node == null)
            return;
        inOrder(node.left, action);
        action.accept(node);
        inOrder(node.right, action);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.fromArray(new Integer[]{1, null, 3,null,null,4});
        MinimumAbsoluteDifferenceInBST minimumAbsoluteDifferenceInBST = new MinimumAbsoluteDifferenceInBST();
        System.out.println(minimumAbsoluteDifferenceInBST.getMinimumDifference(treeNode));
    }

}
