package leetcode

import leetcode.`33_Search_In_Rotated_Sorted_Array`.Solution

/**
 * # 33. Search in Rotated Sorted Array
 * [https://leetcode.com/problems/search-in-rotated-sorted-array/](https://leetcode.com/problems/search-in-rotated-sorted-array/)
 *
 * You are given an integer array nums sorted in ascending order, and an integer `target`.
 *
 * Suppose that `nums` is rotated at some pivot unknown to you beforehand (i.e., `[0,1,2,4,5,6,7]` might
 * become `[4,5,6,7,0,1,2]`).
 *
 * If `target` is found in the array return its index, otherwise, return `-1`.
 *
 * ## Example 1:
 * ```
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * ```
 *
 * ## Example 2:
 * ```
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * ```
 *
 * ## Example 3:
 * ```
 * Input: nums = [1], target = 0
 * Output: -1
 * ```
 *
 * ## Constraints:
 * `1 <= nums.length <= 5000`
 * `-10^4 <= nums[i] <= 10^4`
 * All values of nums are unique.
 * `nums` is guranteed to be rotated at some pivot.
 * `-10^4 <= target <= 10^4`
 */
@Suppress("ClassName")
class `33_Search_In_Rotated_Sorted_Array` {
  class Solution {
    fun search(nums: IntArray, target: Int): Int {
      var start = 0
      var end = nums.size - 1

      while (start <= end) {
        val mid = (end + start) / 2
        if (nums[mid] == target) {
          return mid
        }
        if (nums[start] <= nums[mid]) {
          if (target >= nums[start] && target < nums[mid]) {
            end = mid - 1
          } else {
            start = mid + 1
          }
        } else {
          if (target > nums[mid] && target <= nums[end]) {
            start = mid + 1
          } else {
            end = mid - 1
          }
        }
      }

      return -1
    }
  }
}

fun main() {
  check(Solution().search(intArrayOf(4,5,6,7,0,1,2), 0) == 4)
  check(Solution().search(intArrayOf(4,5,6,7,0,1,2), 3) == -1)
  check(Solution().search(intArrayOf(1), 0) == -1)
}