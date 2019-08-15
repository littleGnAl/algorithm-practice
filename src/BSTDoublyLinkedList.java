import java.util.ArrayList;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class BSTDoublyLinkedList {

    final static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode convert(TreeNode root) {
        if (root == null) return null;
        convert(root.left);
        convert(root.right);

        if (root.left != null) {
            root.left.right = root;
        }

        if (root.right != null) {
            root.right.left = root;
        }

        return root.right;
    }



    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode root = pRootOfTree;
        TreeNode left = convert(root.left);
        TreeNode right = convert(root.right);
        left.right = root;
        root.left = left;
        right.left = root;
        root.right = right;

        return root;
    }
}
