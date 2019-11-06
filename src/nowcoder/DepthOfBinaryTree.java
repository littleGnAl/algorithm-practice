package nowcoder;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class DepthOfBinaryTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode n8 = new TreeNode(8);
        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n7 = new TreeNode(7);
        TreeNode n10 = new TreeNode(10);
        n8.left = n6;
        n8.right = n10;
        n6.left = n4;
        n6.right = n7;
        n4.left = n3;

        // 4
        System.out.println(new DepthOfBinaryTree().TreeDepth(n8));

        TreeNode nn1 = new TreeNode(1);
        TreeNode nn2 = new TreeNode(2);
        TreeNode nn3 = new TreeNode(3);
        TreeNode nn4 = new TreeNode(4);
        TreeNode nn5 = new TreeNode(5);
        TreeNode nn6 = new TreeNode(6);
        TreeNode nn7 = new TreeNode(7);
        nn1.left = nn2;
        nn1.right = nn3;
        nn2.left = nn4;
        nn2.right = nn5;
        nn4.right = nn6;
        nn6.right = nn7;

        // 5
        System.out.println(new DepthOfBinaryTree().TreeDepth(nn1));

        nn1.left = nn2;
        nn1.right = nn6;
        nn6.right = nn7;
        nn2.left = nn3;
        nn3.left = nn4;
        nn4.left = nn5;
        // 6
        System.out.println(new DepthOfBinaryTree().TreeDepth(nn1));
    }
}
