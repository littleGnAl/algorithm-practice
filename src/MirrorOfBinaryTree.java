/**
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	     8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9  11
 *
 *     	镜像二叉树
 *
 *     	     8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class MirrorOfBinaryTree {

    final static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        TreeNode tl = root.left;
        root.left = root.right;
        root.right = tl;

        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }

    static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode n8 = new TreeNode(8);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n9 = new TreeNode(9);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n5 = new TreeNode(5);
        n8.left = n6;
        n8.right = n10;
        n6.left = n5;
        n6.right = n7;
        n10.left = n9;
        n10.right = n11;

        TreeNode n = n8;
        new MirrorOfBinaryTree().Mirror(n);

        inOrder(n);
    }
}
