package leetcode

/**
 * # 11. Container With Most Water
 *
 * [https://leetcode.com/problems/container-with-most-water/](https://leetcode.com/problems/container-with-most-water/)
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn
 * such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms
 * a container, such that the container contains the most water.
 *
 * <img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" alt="">
 *
 * **Note**: You may not slant the container and n is at least 2.
 *
 * ## Example:
 * ```
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * ```
 */
@Suppress("ClassName")
class Container_With_Most_Water {
  class Solution {
    fun maxArea(height: IntArray): Int {
      var i = 0
      var j = height.size - 1
      var result = 0

      while (i < j) {
        val hi = height[i]
        val hj = height[j]
        val minH = kotlin.math.min(hi, hj)
        result = kotlin.math.max(result, minH * (j - i))

        if (hi < hj) {
          ++i
        } else {
          --j
        }
      }

      return result
    }
  }
}

fun main() {
  check(Container_With_Most_Water.Solution().maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)) == 49)
}