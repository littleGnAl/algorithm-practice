package leetcode

import leetcode.Add_Two_Numbers.Solution.ListNode
import leetcode.Add_Two_Numbers.Solution

/**
 * # 2. Add Two Numbers
 * [https://leetcode.com/problems/add-two-numbers/](https://leetcode.com/problems/add-two-numbers/)
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored
 * in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * ```
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * ```
 */
class Add_Two_Numbers {
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

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
      var resultNode: ListNode? = null
      var resultHead: ListNode? = null

      var l1Temp = l1
      var l2Temp = l2

      var carry = 0
      while (l1Temp != null || l2Temp != null) {
        val sum = (l1Temp?.`val` ?: 0) + (l2Temp?.`val` ?: 0) + carry
        val nodeVal = sum % 10
        carry = sum / 10

        if (resultNode == null) {
          resultNode = ListNode(nodeVal)
          resultHead = resultNode
        } else {
          resultNode.next = ListNode(nodeVal)
          resultNode = resultNode.next
        }

        l1Temp = l1Temp?.next
        l2Temp = l2Temp?.next
      }

      if (carry > 0) {
        resultNode?.next = ListNode(carry)
      }

      return resultHead
    }
  }
}

fun ListNode?.nodeToList(): List<Int> {
  var n = this
  val output = mutableListOf<Int>()
  while (n != null) {
    output.add(n.`val`)
    n = n.next
  }

  return output.toList()
}

@Suppress("LocalVariableName")
fun main() {
  val l1_2 = ListNode(2)
  val l1_4 = ListNode(4)
  val l1_3 = ListNode(3)
  l1_2.next = l1_4
  l1_4.next = l1_3

  val l2_5 = ListNode(5)
  val l2_6 = ListNode(6)
  val l2_4 = ListNode(4)
  l2_5.next = l2_6
  l2_6.next = l2_4

  val r_7 = ListNode(7)
  val r_0 = ListNode(0)
  val r_8 = ListNode(8)
  r_7.next = r_0
  r_0.next = r_8

  check(Solution().addTwoNumbers(l1_2, l2_5)?.nodeToList() == r_7.nodeToList())

  val l3_1 = ListNode(1)
  val l3_2 = ListNode(2)
  val l3_4 = ListNode(4)
  val l3_3 = ListNode(3)
  l3_1.next = l3_2
  l3_2.next = l3_4
  l3_4.next = l3_3

  val l4_9_1 = ListNode(9)
  val l4_9_2 = ListNode(9)
  val l4_9_3 = ListNode(9)
  l4_9_1.next = l4_9_2
  l4_9_2.next = l4_9_3

  val r2_0 = ListNode(0)
  val r2_2 = ListNode(2)
  val r2_4 = ListNode(4)
  val r2_4_2 = ListNode(4)
  r2_0.next = r2_2
  r2_2.next = r2_4
  r2_4.next = r2_4_2

  check(Solution().addTwoNumbers(l3_1, l4_9_1)?.nodeToList() == r2_0.nodeToList())

  val l5_5 = ListNode(5)
  val l6_5 = ListNode(5)

  val r3_0 = ListNode(0)
  val r3_1 = ListNode(1)
  r3_0.next = r3_1

  check(Solution().addTwoNumbers(l5_5, l6_5)?.nodeToList() == r3_0.nodeToList())
}





