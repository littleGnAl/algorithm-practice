package nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintBinaryTreeFromTopToBottom {
    final static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(10);
        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        t1.right = t5;
        t5.left = t6;
        t6.right = t7;

        ArrayList<Integer> list = new PrintBinaryTreeFromTopToBottom().PrintFromTopToBottom(t1);
        System.out.println(list.toString());
    }
}
