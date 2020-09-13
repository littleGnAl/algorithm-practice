package leetcode

import java.util.*
import kotlin.collections.HashSet

/**
 * # 15. 3Sum
 *
 * [https://leetcode.com/problems/3sum/](https://leetcode.com/problems/3sum/)
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 * Notice that the solution set must not contain duplicate triplets.
 *
 * ## Example 1:
 * ```
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * ```
 *
 * ## Example 2:
 * ```
 * Input: nums = []
 * Output: []
 * ```
 *
 * ## Example 3:
 * ```
 * Input: nums = [0]
 * Output: []
 * ```
 *
 * ## Constraints:
 * * `0 <= nums.length <= 3000`
 * * `-10^5 <= nums[i] <= 10^5`
 */
@Suppress("ClassName")
class `15_3Sum` {
  class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
      if (nums.size < 3) return emptyList()

      Arrays.sort(nums)

      val set = HashSet<List<Int>>()
      for (i in 0 until nums.size - 2) {
        var j = i + 1
        var k = nums.size - 1
        while (j < k) {
          val sum = nums[i] + nums[j] + nums[k]
          when {
            sum == 0 -> {
              set.add(listOf(nums[i], nums[j++], nums[k--]))
            }
            sum > 0 -> {
              k--
            }
            sum < 0 -> {
              j++
            }
          }
        }
      }

      return set.toList()
    }
  }
}

fun main() {
  check(`15_3Sum`.Solution().threeSum(intArrayOf(-1,0,1,2,-1,-4)) ==
      listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)))
  check(`15_3Sum`.Solution().threeSum(intArrayOf()) ==
      listOf<List<Int>>())
  check(`15_3Sum`.Solution().threeSum(intArrayOf(0)) ==
      listOf<List<Int>>())
}