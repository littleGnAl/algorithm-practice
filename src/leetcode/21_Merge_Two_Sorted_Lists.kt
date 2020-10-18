package leetcode

import leetcode.`21_Merge_Two_Sorted_Lists`.Solution.ListNode

/**
 * # 21. Merge Two Sorted Lists
 *
 * [https://leetcode.com/problems/merge-two-sorted-lists/](https://leetcode.com/problems/merge-two-sorted-lists/)
 *
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by
 * splicing together the nodes of the first two lists.
 *
 * ## Example:
 * ```
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * ```
 */
@Suppress("ClassName")
class `21_Merge_Two_Sorted_Lists` {
  /**
   * Example:
   * var li = ListNode(5)
   * var v = li.`val`
   * Definition for singly-linked list.
   * class ListNode(var `val`: Int) {
   *     var next: ListNode? = null
   * }
   */
  class Solution {
    class ListNode(var `val`: Int) {
      var next: ListNode? = null
    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
      if (l1 == null || l2 == null) return l1 ?: l2

      var p1 = l1
      var p2 = l2
      var result: ListNode? = ListNode(0)
      val head = result

      while (p1 != null && p2 != null) {
        if (p1.`val` > p2.`val`) {
          result?.next = p2
          p2 = p2.next
        } else {
          result?.next = p1
          p1 = p1.next
        }
        result = result?.next
      }

      if (p1 != null) {
        result?.next = p1
      }
      if (p2 != null) {
        result?.next = p2
      }

      return head?.next
    }
  }
}

fun main() {
  val l11 = ListNode(1)
  val l12 = ListNode(2)
  val l14 = ListNode(4)
  l11.next = l12
  l12.next = l14

  val l21 = ListNode(1)
  val l23 = ListNode(3)
  val l24 = ListNode(4)
  l21.next = l23
  l23.next = l24

  var l = `21_Merge_Two_Sorted_Lists`.Solution().mergeTwoLists(l11, l21)
  while (l != null) {
    print(l.`val`.toString() + ",")
    l = l.next
  }
}