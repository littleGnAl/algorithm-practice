package nowcoder;

import java.util.*;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintBinaryTreeInZOrder {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(pRoot);
        int depth = 1;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            ArrayList<Integer> l = new ArrayList<>();
            if (depth % 2 != 0) {
                while (!s1.isEmpty()) {
                    TreeNode n = s1.pop();
                    l.add(n.val);
                    if (n.left != null) {
                        s2.push(n.left);
                    }
                    if (n.right != null) {
                        s2.push(n.right);
                    }
                }
            } else {
                while (!s2.isEmpty()) {
                    TreeNode n = s2.pop();
                    l.add(n.val);
                    if (n.right != null) {
                        s1.push(n.right);
                    }
                    if (n.left != null) {
                        s1.push(n.left);
                    }
                }
            }

            result.add(l);
            ++depth;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        // [[1], [3, 2], [4, 5]]
        System.out.println(new PrintBinaryTreeInZOrder().Print(n1));
    }
}
