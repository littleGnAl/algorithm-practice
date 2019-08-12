/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class SubstructureOfTree {

    final static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;

        boolean result = false;
        if (root1.val == root2.val) {
            result = isSubTree(root1, root2);
        }
        if (!result) {
            result = HasSubtree(root1.left, root2);
        }
        if (!result) {
            result = HasSubtree(root1.right, root2);
        }

        return result;
    }

    boolean isSubTree(TreeNode node1, TreeNode node2) {
        if (node2 == null) return true;
        if (node1 == null) return false;
        if (node1.val != node2.val) return false;

        return isSubTree(node1.left, node2.left) && isSubTree(node1.right, node2.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        t1.right = t5;
        t5.left = t6;
        t5.right = t7;

        TreeNode tt1 = new TreeNode(6);
        TreeNode tt2 = new TreeNode(4);
        TreeNode tt3 = new TreeNode(7);
        tt1.left = tt2;
        tt1.right = tt3;

        System.out.println(new SubstructureOfTree().HasSubtree(t1, tt1));
        System.out.println(new SubstructureOfTree().HasSubtree(t1, null));
    }
}
