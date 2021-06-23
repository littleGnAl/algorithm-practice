package leetcode

/**
 * # 215. Kth Largest Element in an Array
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 *
 *
 * ## Example 1:
 * ```
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * ```
 *
 * ## Example 2:
 * ```
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * ```
 *
 * ## Constraints:
 * ```
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * ```
 */
@Suppress("ClassName")
class `215_Kth_Largest_Element_In_An_Array.kt` {
  class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
      val len = nums.size - 1
      val begin = nums.size / 2 - 1
      for (i in begin downTo 0) {
        maxHeapify(nums, i, len)
      }

      for (i in len downTo (len - k + 1)) {
        swap(nums, 0, i)
        maxHeapify(nums, 0, i - 1)
      }

      return nums[0]
    }

    private fun swap(nums: IntArray, a: Int, b: Int) {
      val temp = nums[a]
      nums[a] = nums[b]
      nums[b] = temp
    }

    private fun maxHeapify(nums: IntArray, index: Int, len: Int) {
      val li = 2 * index + 1
      val ri = li + 1 // 2 * index + 2
      var maxIndex = li
      if (li > len) return

      if (ri <= len && nums[ri] > nums[li]) {
        maxIndex = ri
      }

      if (nums[maxIndex] > nums[index]) {
        swap(nums, maxIndex, index)
        maxHeapify(nums, maxIndex, len)
      }
    }
  }
}