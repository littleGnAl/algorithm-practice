package leetcode

/**
 * # 7. Reverse Integer
 *
 * [https://leetcode.com/problems/reverse-integer/](https://leetcode.com/problems/reverse-integer/)
 *
 * Given a 32-bit signed integer, reverse digits of an integer.

 * ## Example 1:
 * ```
 * Input: 123
 * Output: 321
 * ```
 *
 * ## Example 2:
 * ```
 * Input: -123
 * Output: -321
 * ```
 *
 * ## Example 3:
 * ```
 * Input: 120
 * Output: 21
 * ```
 * ## Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed
 * integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0
 * when the reversed integer overflows.
 */
@Suppress("ClassName")
class Reverse_Integer {
  class Solution {
    fun reverse(x: Int): Int {
      var i = x

      var reverse = 0
      while (i != 0) {
        val p = i % 10
        i /= 10

        if (reverse > Int.MAX_VALUE / 10 || (reverse == Int.MAX_VALUE / 10 && p > 7 )) {
          return 0
        }

        if (reverse < Int.MIN_VALUE / 10 || (reverse == Int.MIN_VALUE / 10 && p < -8)) {
          return 0
        }

        reverse = reverse * 10 + p
      }

      return reverse
    }
  }
}

fun main() {
  check(Reverse_Integer.Solution().reverse(123) == 321)
  check(Reverse_Integer.Solution().reverse(-123) == -321)
  check(Reverse_Integer.Solution().reverse(120) == 21)
  check(Reverse_Integer.Solution().reverse(1534236469) == 0)
}