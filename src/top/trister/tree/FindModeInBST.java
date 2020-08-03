package top.trister.tree;

import top.trister.tree.struct.TreeNode;

import javax.transaction.TransactionRequiredException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindModeInBST {

    public int[] findMode(TreeNode root) {
        //中序遍历的树是有序的，因此使用双指针可以找到众数
        //维护 curTimes 和 maxTimes 如果prev和cur相同，则 curTimes+=1
        //  如果curTimes>maxTimes则清空res，并添加当前节点，更新maxTimes
        //  如果curTimes==maxTimes则添加当前节点
        //  如果curTimes<maxTimes则忽略
        Set<Integer> set = new HashSet<>();
        BiConsumer<TreeNode, TreeNode> biConsumer = new BiConsumer<TreeNode, TreeNode>() {
            int curTimes = 0;
            int maxTimes = 0;

            @Override
            public void accept(TreeNode prev, TreeNode cur) {
                if (prev == null) {
                    curTimes = 1;
                    set.add(cur.val);
                } else {
                    if (prev.val == cur.val) {
                        curTimes++;
                    } else {
                        curTimes = 1;
                    }
                }
                if (curTimes > maxTimes) {
                    maxTimes = curTimes;
                    set.clear();
                    set.add(cur.val);
                } else if (curTimes == maxTimes) {
                    set.add(cur.val);
                }
            }
        };
        morris(root, biConsumer);
        int[] re = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            re[i++] = integer;
        }
        return re;
    }

    /*
        morris 中序遍历
        1. 如果当前节点的 left 为空，则输出当前节点并将其 right 作为当前节点。
        2. 如果当前节点的 left 不为空，则在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
            a. 如果前驱节点的 right 为空，将它的 right设置为当前节点。当前节点更新为当前节点的 left。
            b. 如果前驱节点的 right 为当前节点，将它的 right 重新设置为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的right
        3. 重复以上1，2直到当前节点为空。
     */
    void morris(TreeNode node, BiConsumer<TreeNode, TreeNode> biConsumer) {
        TreeNode cur = node;
        TreeNode prev = null;
        /*
            从根节点开始，将各个邻接节点连接起来，直到最小的节点
            随后从最小节点开始返回（返回时利用了之前建立的前驱链接，实现了后驱的查找），返回的过程中断开新建的链接并进行访问
         */
        while (cur != null) {
            if (cur.left == null) {
                biConsumer.accept(prev, cur);
                prev = cur;
                cur = cur.right;
            } else {
                //如果直接使用prev的话则会出现尚未访问到节点，就生成了prev，这里需要的是在非递减序列中的左连接节点
                TreeNode processor = cur.left;
                //找到当前节点的中序前驱节点
                //如果存在 left 则 left 中的最大值就是前驱
                //最大值则是最右节点
                //并且前序节点的右指针必定是空的，因为在当前子树中没有比这个值更大的节点了
                while (processor.right != null && processor.right != cur) {
                    processor = processor.right;
                }
                if (processor.right == cur) {
                    //恢复结构，2.b步骤
                    biConsumer.accept(prev, cur);
                    processor.right = null;
                    prev = cur;
                    cur = cur.right;
                } else {
                    //建立链接，2.a步骤
                    processor.right = cur;
                    cur = cur.left;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.fromArray(new Integer[]{1, null, 2});
        FindModeInBST findModeInBST = new FindModeInBST();
        int[] mode = findModeInBST.findMode(treeNode);
        for (int i : mode) {
            System.out.println(i);
        }
    }


}
