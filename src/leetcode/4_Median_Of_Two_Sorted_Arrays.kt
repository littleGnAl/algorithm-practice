package leetcode

import leetcode.Median_Of_Two_Sorted_Arrays.Solution

/**
 * # 4. Median of Two Sorted Arrays
 *
 * [https://leetcode.com/problems/median-of-two-sorted-arrays/](https://leetcode.com/problems/median-of-two-sorted-arrays/)
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Return the median of the two sorted arrays.
 *
 * Follow up: The overall run time complexity should be O(log (m+n)).
 *
 * ## Example 1:
 * ```
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * ```
 *
 * ## Example 2:
 *
 * ```
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * ```
 *
 * ## Example 3:
 * ```
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * ```
 *
 * ## Example 4:
 * ```
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * ```
 *
 * ## Example 5:
 * ```
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 * ```
 *
 * ## Constraints:
 * ```
 * nums1,length == m
 * nums2,length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * ```
 */
class Median_Of_Two_Sorted_Arrays {
  class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
      if (nums1.size > nums2.size) {
        return findMedianSortedArrays(nums2, nums1)
      }

      val m = nums1.size
      val n = nums2.size

      var lo = 0
      var hi = m

      while (lo <= hi) {
        val i = lo + (hi - lo) / 2
        val j = (m + n + 1) / 2 - i

        val maxLeftA = if (i == 0) Integer.MIN_VALUE else nums1[i - 1]
        val maxLeftB = if (j == 0) Integer.MIN_VALUE else nums2[j - 1]
        val minRightA = if (i == m) Integer.MAX_VALUE else nums1[i]
        val minRightB = if (j == n) Integer.MAX_VALUE else nums2[j]

        if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
          return if ((m + n) % 2 == 0) {
            (kotlin.math.max(maxLeftA, maxLeftB) + kotlin.math.min(minRightA, minRightB)) / 2.0
          } else {
            kotlin.math.max(maxLeftA, maxLeftB).toDouble()
          }
        } else if (maxLeftA > minRightB) {
          hi = i - 1
        } else {
          lo = i + 1
        }
      }

      return 0.0
    }
  }
}

fun main() {
  check(Solution().findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)) == 2.00000)
  check(Solution().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)) == 2.50000)
  check(Solution().findMedianSortedArrays(intArrayOf(), intArrayOf(2, 3)) == 2.50000)
  check(Solution().findMedianSortedArrays(intArrayOf(0, 0), intArrayOf(0, 0)) == 0.00000)
  check(Solution().findMedianSortedArrays(intArrayOf(), intArrayOf(1)) == 1.00000)
  check(Solution().findMedianSortedArrays(intArrayOf(2), intArrayOf()) == 2.00000)
  check(Solution().findMedianSortedArrays(intArrayOf(), intArrayOf(2)) == 2.00000)
}