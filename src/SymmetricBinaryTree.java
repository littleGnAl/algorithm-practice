import java.util.ArrayList;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetricBinaryTree {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + this.val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;

        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val
                && isSymmetrical(left.left, right.right)
                && isSymmetrical(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t22 = new TreeNode(2);
        TreeNode t33 = new TreeNode(3);
        t1.left = t2;
        t2.left = t3;
        t1.right = t22;
        t22.right = t33;
        // true
        System.out.println(new SymmetricBinaryTree().isSymmetrical(t1));
    }
}
