package nowcoder;

import java.util.ArrayList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintBinaryTreeInMultipleLines {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        depth(pRoot, 1, result);
        return result;
    }

    void depth(TreeNode node, int depth, ArrayList<ArrayList<Integer>> result) {
        if (node == null) return;
        if (depth > result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(depth - 1).add(node.val);

        depth(node.left, depth + 1, result);
        depth(node.right, depth + 1, result);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        // [[1], [2, 3], [4, 5, 6, 7]]
        System.out.println(new PrintBinaryTreeInMultipleLines().Print(n1));
    }
}
