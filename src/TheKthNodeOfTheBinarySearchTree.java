/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class TheKthNodeOfTheBinarySearchTree {
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

    int index = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) return node;
            ++index;
            if (index == k) return pRoot;
            node = KthNode(pRoot.right, k);
            if (node != null) return node;
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n6 = new TreeNode(6);
        TreeNode n8 = new TreeNode(8);
        n5.left = n3;
        n5.right = n7;
        n3.left = n2;
        n3.right = n4;
        n7.left = n6;
        n7.right = n8;

        // 4
        System.out.println(new TheKthNodeOfTheBinarySearchTree().KthNode(n5, 3));
    }
}
