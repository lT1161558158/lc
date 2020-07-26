package top.trister.tree;

import top.trister.tree.struct.TreeNode;

public class FindModeInBST {
    public int[] findMode(TreeNode root) {

    }
    void rank(TreeNode node,int rank,TreeNode rankNode,TreeNode before){
        if (node==null)
            return;
        if (before!=null && node.val==before.val){
            rank++;
        }

    }
}
