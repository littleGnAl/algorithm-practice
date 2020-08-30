package leetcode

/**
 * # 5. Longest Palindromic Substring
 * [https://leetcode.com/problems/longest-palindromic-substring/](https://leetcode.com/problems/longest-palindromic-substring/)
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * ## Example 1:
 * ```
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * ```
 *
 * ## Example 2:
 * ```
 * Input: "cbbd"
 * Output: "bb"
 * ```
 */
@Suppress("ClassName")
class Longest_Palindromic_Substring {
  class Solution {
    fun longestPalindrome(s: String): String {
      if (s.isEmpty()) return ""

      var start = 0
      var end = 0

      for (i in s.indices) {
        val len1 = expandAroundCenter(s, i, i)
        val len2 = expandAroundCenter(s, i, i + 1)
        val len = kotlin.math.max(len1, len2)
        if (len > end - start) {
          start = i - (len - 1) / 2
          end = i + len / 2
        }
      }

      return s.substring(start, end + 1)
    }

    private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
      var l = left
      var r = right

      while (l >= 0 && r < s.length && s[l] == s[r]) {
        --l
        ++r
      }

      return r - l -1
    }
  }
}

fun main() {
  check(Longest_Palindromic_Substring.Solution().longestPalindrome("babad") == "aba")
  check(Longest_Palindromic_Substring.Solution().longestPalindrome("cbbd") == "bb")
}