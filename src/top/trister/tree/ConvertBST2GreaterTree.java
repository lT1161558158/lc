package top.trister.tree;

import top.trister.tree.struct.TreeNode;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertBST2GreaterTree {
    int sum = 0;

    //反中序遍历,操作时需要取出一个累加和
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            ///对值进行操作操作
            sum += root.val;
            root.val = sum;
            //-------------
            convertBST(root.left);
        }
        return root;
    }



    public static void main(String[] args) {
        Integer[] nums = new Integer[]{5, 2, 13, 1, 3, 10, 24};
        TreeNode root = TreeNode.fromArray(nums);
        ConvertBST2GreaterTree convertBST2GreaterTree = new ConvertBST2GreaterTree();
        TreeNode treeNode = convertBST2GreaterTree.convertBST(root);
        System.out.println(treeNode.structString());
    }
}
