package leetcode

/**
 * [https://leetcode.com/problems/two-sum/](https://leetcode.com/problems/two-sum/)
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * ```
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * ```
 */
class Solution {
  fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for ((index, n) in nums.withIndex()) {
      val temp = target - n
      if (map.containsKey(temp)) {
        return intArrayOf(map[temp] ?: 0, index)
      }

      map[n] = index
    }

    throw IllegalArgumentException("No two sum solution")
  }
}

fun main() {
  check(Solution().twoSum(intArrayOf(2, 7, 11, 15), 9) contentEquals intArrayOf(0, 1))
  check(Solution().twoSum(intArrayOf(2, 11, 15, 7), 9) contentEquals intArrayOf(0, 3))
  check(Solution().twoSum(intArrayOf(2, 11, 15, 7), 22) contentEquals intArrayOf(2, 3))
  check(Solution().twoSum(intArrayOf(2, 11, 15, 7), 26) contentEquals intArrayOf(1, 2))
  try {
    Solution().twoSum(intArrayOf(2, 11, 15, 7), 36) contentEquals IntArray(2)
  } catch (e: Exception) {
    check(e is IllegalArgumentException)
  }
  check(Solution().twoSum(intArrayOf(3, 3), 6) contentEquals intArrayOf(0, 1))
}