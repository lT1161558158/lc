package top.trister.tree;

import top.trister.tree.struct.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderBottom(root, res, 0);
        Collections.reverse(res);
        return res;
    }

    private void levelOrderBottom(TreeNode node, List<List<Integer>> layers, int depth) {
        if (node == null)
            return;
        if (layers.size() <= depth) {
            layers.add(new ArrayList<>());
        }
        List<Integer> level = layers.get(depth);
        level.add(node.val);
        depth++;
        levelOrderBottom(node.left, layers, depth);
        levelOrderBottom(node.right, layers, depth);
    }
}
