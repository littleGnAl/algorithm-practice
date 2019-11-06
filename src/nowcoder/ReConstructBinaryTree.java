package nowcoder;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {

    final static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    final TreeNode constructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                root.left = constructBinaryTree(
                        pre,
                        preStart + 1,
                        preStart + i - inStart,
                        in,
                        inStart,
                        i - 1);
                root.right = constructBinaryTree(
                        pre,
                        preStart + i - inStart + 1,
                        preEnd,
                        in,
                        i + 1,
                        inEnd);
                break;
            }
        }

        return root;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) return null;
        return constructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = new ReConstructBinaryTree().reConstructBinaryTree(pre, in);
        preOrder(node);
        System.out.println();
        inOrder(node);
    }
}
