package leetcode

import java.util.*

/**
 * # 16. 3Sum Closest
 *
 * [https://leetcode.com/problems/3sum-closest/](https://leetcode.com/problems/3sum-closest/)
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * ## Example 1:
 * ```
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * ```
 *
 * ## Constraints:
 *
 * * `3 <= nums.length <= 10^3`
 * * `-10^3 <= nums[i] <= 10^3`
 * * `-10^4 <= target <= 10^4`
 */
@Suppress("ClassName")
class `16_3Sum_Closest` {
  class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
      if (nums.size < 3) return 0

      Arrays.sort(nums)

      var difference = Int.MAX_VALUE
      for (i in 0 until nums.size - 2) {
        var j = i + 1
        var k = nums.size - 1
        while (j < k) {
          val sum = nums[i] + nums[j] + nums[k]
          if (kotlin.math.abs(target - sum) < kotlin.math.abs(difference)) {
            difference = target - sum
          }

          if (sum < target) {
            ++j
          } else {
            --k
          }
        }
      }

      return target - difference
    }
  }
}

fun main() {
  check(`16_3Sum_Closest`.Solution().threeSumClosest(intArrayOf(-1,2,1,-4), 1) == 2)
}