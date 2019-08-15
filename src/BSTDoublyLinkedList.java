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

    private TreeNode lastNode = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            lastNode = pRootOfTree;
            return pRootOfTree;
        }

        TreeNode left = Convert(pRootOfTree.left);
        if (left != null) {
            lastNode.right = pRootOfTree;
            pRootOfTree.left = lastNode;
        }

        lastNode = pRootOfTree;

        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }

        return left == null ? pRootOfTree : left;
    }

    public static void main(String[] args) {
        TreeNode n10 = new TreeNode(10);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n12 = new TreeNode(12);
        n10.left = n5;
        n5.left = n3;
        n5.right = n7;
        n3.left = n1;
        n3.right = n4;
        n10.right = n12;

        ArrayList<Integer> r = new ArrayList<>();
        TreeNode n = new BSTDoublyLinkedList().Convert(n10);
        System.out.println(n);
        while (n != null) {
            r.add(n.val);
            n = n.right;
        }

        System.out.println(r.toString());
    }
}
