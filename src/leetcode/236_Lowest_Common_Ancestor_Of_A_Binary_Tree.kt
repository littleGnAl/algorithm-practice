package leetcode

/**
 * # 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * ## Example 1:
 *
 * ![](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)
 *
 * ```
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * ```
 *
 * ## Example 2:
 *
 * ![](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)
 *
 * ```
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * ```
 *
 * ## Example 3:
 * ```
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * ```
 *
 * ## Constraints:
 * ```
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 * ```
 */
@Suppress("ClassName")
class `236_Lowest_Common_Ancestor_Of_A_Binary_Tree` {
  class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }

  class Solution {

    private var ans: TreeNode? = null

    private fun dfs(root: TreeNode?, p: TreeNode?, q: TreeNode?) : Boolean {
      if (root == null) return false
      val lson = dfs(root.left, p, q)
      val rson = dfs(root.right, p, q)
      if ((lson && rson) || ((root.`val` == p!!.`val` || root.`val` == q!!.`val`) && (lson || rson))) {
        ans = root
      }

      return lson || rson || (root.`val` == p!!.`val` || root.`val` == q!!.`val`)
    }

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
      dfs(root, p, q)
      return ans
    }
  }
}