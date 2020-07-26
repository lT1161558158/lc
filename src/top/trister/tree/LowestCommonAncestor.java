package top.trister.tree;

import top.trister.tree.struct.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;

        while (node != null) {
            //因为是bst,所以只有当两个值都属于边界外才需要移动边界,否则说明当前节点就是分界点
            if (p.val > node.val && q.val > node.val) {
                node = node.right;
            } else if (p.val < node.val && q.val < node.val) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
    //做了额外的事情,即找出路径,因此空间复杂度会有O(n)级别
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null)
//            return null;
//        List<TreeNode> pPath = searchPath(root, p.val);
//        List<TreeNode> qPath = searchPath(root, q.val);
//        if (contains(pPath, q.val))
//            return q;
//        if (contains(qPath, p.val))
//            return p;
//        int minimum = Integer.min(pPath.size(), qPath.size());
//        int i = 1;
//        for (; i < minimum; i++) {
//            if (pPath.get(i).val != qPath.get(i).val) {
//                return pPath.get(i - 1);
//            }
//        }
//        return pPath.get(i-1);
//    }
//
//    boolean contains(List<TreeNode> nodes, int target) {
//        for (TreeNode node : nodes) {
//            if (node.val == target)
//                return true;
//        }
//        return false;
//    }
//
//    List<TreeNode> searchPath(TreeNode node, int target) {
//        List<TreeNode> stack = new ArrayList<>();
//        while (node.val != target) {
//            stack.add(node);
//            if (node.val > target) {
//                node = node.left;
//            } else {
//                node = node.right;
//            }
//        }
//        return stack;
//    }

    public static void main(String[] args) {
        //[5,3,6,2,4,null,null,1]
        //1
        //4
        Integer[] nums = new Integer[]{5,3,6,2,4,null,null,1};
        TreeNode fromArray = TreeNode.fromArray(nums);
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode treeNode = lowestCommonAncestor.lowestCommonAncestor(fromArray, new TreeNode(1), new TreeNode(4));
        System.out.println(treeNode.val);
    }
}
