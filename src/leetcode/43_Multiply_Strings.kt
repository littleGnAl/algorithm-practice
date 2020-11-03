package leetcode

import java.lang.StringBuilder

/**
 * # 43. Multiply Strings
 * [https://leetcode.com/problems/multiply-strings/](https://leetcode.com/problems/multiply-strings/)
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * ## Example 1:
 * ```
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * ```
 *
 * ## Example 2:
 * ```
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * ```
 *
 * ## Constraints:
 *
 * `1 <= num1.length, num2.length <= 200`
 * `num1` and `num2` consist of digits only.
 * Both `num1` and `num2` do not contain any leading zero, except the number `0` itself.
 */
@Suppress("ClassName")
class `43_Multiply_Strings` {
  class Solution {
    fun multiply(num1: String, num2: String): String {
      if (num1 == "0" || num2 == "0") return "0"

      val m = num1.length
      val n = num2.length

      val ansArr = IntArray(m + n)
      val sb = StringBuilder()

      for (i in m - 1 downTo 0) {
        val x = num1[i] - '0'
        for (j in n - 1 downTo 0) {
          val y = num2[j] - '0'
          ansArr[i + j + 1] += x * y
        }
      }

      for (i in m + n - 1 downTo 1) {
        ansArr[i - 1] += ansArr[i] / 10
        ansArr[i] %= 10
      }

      val index = if (ansArr[0] == 0) 1 else 0
      for (i in index until m + n) {
        sb.append(ansArr[i])
      }

      return sb.toString()
    }
  }
}

fun main() {
  check(`43_Multiply_Strings`.Solution().multiply("123", "456") == "56088")
  check(`43_Multiply_Strings`.Solution().multiply("2", "3") == "6")
  check(`43_Multiply_Strings`.Solution().multiply("123456789", "987654321") == "121932631112635269")
}