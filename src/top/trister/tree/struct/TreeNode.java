package top.trister.tree.struct;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode fromArray(Integer[] arr) {
        if (arr == null)
            return null;
        if (arr.length == 0)
            return null;
        TreeNode root = new TreeNode(arr[0]);
        Map<Integer, TreeNode> temp = new HashMap<>();
        temp.put(0, root);
        //i/2=root
        //i%2==1 -> left
        //i%2==0 -> right
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == null)
                continue;
            int rootIndex = (i - 1) / 2;
            TreeNode parent = temp.get(rootIndex);
            if (parent == null) {
                throw new IllegalStateException("not find parent for index " + i);
            }
            boolean left = i % 2 == 1;
            TreeNode now = new TreeNode(arr[i]);
            if (left) {
                parent.left = now;
            } else {
                parent.right = now;
            }
            temp.put(i, now);
        }
        return root;
    }


    public String structString() {
        List<String> list = new LinkedList<>();
        search(this, 0, (node, deep) -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < deep; i++) {
                sb.append(" ");
            }
            sb.append(node.val);
            list.add(sb.toString());
        });
        String res = list.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.joining("\n"));
        return res;
    }

    public static void search(TreeNode node, int deep, BiConsumer<TreeNode, Integer> action) {
        if (node != null) {
            action.accept(node, deep);
            search(node.left, deep + 1, action);
            search(node.right, deep + 1, action);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = fromArray(new Integer[]{1, 2, 3, 4, 5, null, 7, null, 9});
        System.out.println(treeNode.structString());
    }
}
