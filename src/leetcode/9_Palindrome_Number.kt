package leetcode

/**
 * # 9. Palindrome Number
 *
 * [https://leetcode.com/problems/palindrome-number/](https://leetcode.com/problems/palindrome-number/)
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * ## Example 1:
 * ```
 * Input: 121
 * Output: true
 * ```
 *
 * ## Example 2:
 * ```
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * ```
 *
 * ## Example 3:
 * ```
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * ```
 *
 * ## Follow up:
 * Coud you solve it without converting the integer to a string?
 */
@Suppress("ClassName")
class Palindrome_Number {
  class Solution {
    fun isPalindrome(x: Int): Boolean {
      var i = x

      if (i == 0) return true
      if (i < 0) return false
      if (i % 10 == 0) return false

      var reverse = 0
      while (i > reverse) {
        val p = i % 10
        i /= 10

        reverse = reverse * 10 + p
      }

      return i == reverse || i == reverse / 10
    }
  }
}

fun main() {
  check(Palindrome_Number.Solution().isPalindrome(121))
  check(!Palindrome_Number.Solution().isPalindrome(-121))
  check(!Palindrome_Number.Solution().isPalindrome(10))
  check(Palindrome_Number.Solution().isPalindrome(0))
}