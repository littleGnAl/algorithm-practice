import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一
 * 直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class BinaryTreePathOfValue {

    final static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    void findPath(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> path, TreeNode node, int target) {
        if (node == null) return;
        path.add(node.val);
        if (node.val == target && node.left == null && node.right == null) {
            ArrayList<Integer> newPath = new ArrayList<>(path);
            if (results.size() > 0 && results.get(0).size() < newPath.size()) {
                results.add(0, newPath);
            } else {
                results.add(newPath);
            }
        }

        findPath(results, path, node.left, target - node.val);
        findPath(results, path, node.right, target - node.val);

        path.remove(path.size() - 1);
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null) return results;
        if (root.val > target) return results;

        findPath(results, path, root, target);

        return results;
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        TreeNode n10 = new TreeNode(10);
        TreeNode n12 = new TreeNode(12);
        n4.left = n2;
        n2.left = n1;
        n2.right = n3;
        n4.right = n6;
        n6.left = n5;
        n5.right = n7;
        n6.right = n10;
        n10.right = n12;
        ArrayList<ArrayList<Integer>> results = new BinaryTreePathOfValue().FindPath(n4, 10);
        System.out.println(results.toString());

        TreeNode nn10 = new TreeNode(10);
        TreeNode nn8 = new TreeNode(8);
        TreeNode nn5 = new TreeNode(5);
        TreeNode nn9 = new TreeNode(9);
        TreeNode nn13 = new TreeNode(13);
        TreeNode nn11 = new TreeNode(11);
        nn10.left = nn8;
        nn8.left = nn5;
        nn8.right = nn9;
        nn10.right = nn13;
        nn13.left = nn11;
        ArrayList<ArrayList<Integer>> results2 = new BinaryTreePathOfValue().FindPath(nn10, 23);
        System.out.println(results2);
    }
}
