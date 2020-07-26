package top.trister.tree;

import top.trister.tree.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(paths, root, "");
        return paths;
    }

    private void binaryTreePaths(List<String> paths, TreeNode node, String prefix) {
        if (node == null)
            return;
        prefix += node.val;
        if (node.left == null && node.right == null) {
            paths.add(prefix);
        } else {
            prefix += "->";
            binaryTreePaths(paths, node.left, prefix);
            binaryTreePaths(paths, node.right, prefix);
        }
    }
}
