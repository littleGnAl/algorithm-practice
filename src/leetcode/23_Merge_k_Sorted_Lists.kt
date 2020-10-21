package leetcode

import leetcode.`23_Merge_k_Sorted_Lists`.ListNode

/**
 * # 23. Merge k Sorted Lists
 * [https://leetcode.com/problems/merge-k-sorted-lists/](https://leetcode.com/problems/merge-k-sorted-lists/)
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * ## Example 1:
 * ```
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * ```
 *
 * ## Example 2:
 * ```
 * Input: lists = []
 * Output: []
 * ```
 *
 * ## Example 3:
 * ```
 * Input: lists = [[]]
 * Output: []
 * ```
 *
 * ## Constraints:
 *
 * * `k == lists.length`
 * * `0 <= k <= 10^4`
 * * `0 <= lists[i].length <= 500`
 * * `-10^4 <= lists[i][j] <= 10^4`
 * * `lists[i]` is sorted in ascending order.
 * * The sum of `lists[i].length` won't exceed `10^4`.
 */
@Suppress("ClassName")
class `23_Merge_k_Sorted_Lists` {
  class ListNode(var `val`: Int) {
    var next: ListNode? = null
  }

  class Solution {
    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
      var ll1 = l1
      var ll2 = l2
      var h: ListNode? = ListNode(0)
      val ans = h

      while (ll1 != null && ll2 != null) {
        if (ll1.`val` < ll2.`val`) {
          h?.next = ll1
          h = h?.next
          ll1 = ll1.next
        } else {
          h?.next = ll2
          h = h?.next
          ll2 = ll2.next
        }
      }

      if (ll1 == null) {
        h?.next = ll2
      }

      if (ll2 == null) {
        h?.next = ll1
      }

      return ans?.next
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
      if (lists.isEmpty()) return null

      var interval = 1

      while (interval < lists.size) {
        var i = 0
        while (i + interval < lists.size) {
          lists[i] = mergeTwoLists(lists[i], lists[i + interval])
          i += interval * 2
        }

        interval *= 2
      }

      return lists[0]
    }
  }
}

fun main() {
  // [[1,4,5],[1,3,4],[2,6]]
  val l11 = ListNode(1)
  val l14 = ListNode(4)
  val l15 = ListNode(5)
  l11.next = l14
  l14.next = l15

  val l21 = ListNode(1)
  val l23 = ListNode(3)
  val l24 = ListNode(4)
  l21.next = l23
  l23.next = l24

  val l32 = ListNode(2)
  val l36 = ListNode(6)
  l32.next = l36

  var r = `23_Merge_k_Sorted_Lists`.Solution().mergeKLists(arrayOf(l11, l21, l32))
  while (r != null) {
    print(r.`val`.toString() + ",")
    r = r.next
  }
}