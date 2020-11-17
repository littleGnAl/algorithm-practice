package leetcode

import java.util.*

/**
 * # 46. Permutations
 * Given an array `nums` of distinct integers, return all the possible permutations. You can return the answer in **any order**.
 *
 * ## Example 1:
 * ```
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * ```
 *
 * ## Example 2:
 * ```
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * ```
 *
 * ## Example 3:
 * ```
 * Input: nums = [1]
 * Output: [[1]]
 * ```
 *
 * ## Constraints:
 *
 * * `1 <= nums.length <= 6`
 * * `-10 <= nums[i] <= 10`
 * * All the integers of `nums` are unique.
 */
@Suppress("ClassName")
class `46_Permutations` {
  class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
      val len = nums.size
      val res = mutableListOf<MutableList<Int>>()
      if (len == 0) return res

      val used = BooleanArray(len)
      val path: Deque<Int> = ArrayDeque(len)

      dfs(nums, len, 0, path, used, res)

      return res
    }

    private fun dfs(
        nums: IntArray,
        len: Int,
        depth: Int,
        path: Deque<Int>,
        used: BooleanArray,
        res: MutableList<MutableList<Int>>
    ) {
      if (depth == len) {
        res.add(ArrayList(path))
        return
      }

      for (i in 0 until len) {
        if (!used[i]) {
          path.addLast(nums[i])
          used[i] = true

          dfs(nums, len, depth + 1, path, used, res)

          used[i] = false
          path.removeLast()
        }
      }
    }
  }
}

fun main() {
  check(`46_Permutations`.Solution().permute(intArrayOf(1,2,3)) == listOf(
      listOf(1,2,3),
      listOf(1,3,2),
      listOf(2,1,3),
      listOf(2,3,1),
      listOf(3,1,2),
      listOf(3,2,1)))
}