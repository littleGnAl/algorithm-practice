package leetcode

import leetcode.Longest_Common_Prefix.Solution

/**
 * # 14. Longest Common Prefix
 *
 * [https://leetcode.com/problems/longest-common-prefix/](https://leetcode.com/problems/longest-common-prefix/)
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * ## Example 1:
 * ```
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * ```
 *
 * ## Example 2:
 * ```
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * ```
 *
 * ## Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
class Longest_Common_Prefix {
  class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
      if (strs.isEmpty()) return ""

      var prefix = ""
      val str = strs[0]
      for (index in str.indices) {
        val c = str[index]
        for (i in 1 until strs.size) {
          val s = strs[i]
          if (index > s.length - 1) {
            return prefix
          }
          if (s[index] != c) {
            return prefix
          }
        }

        prefix += c
      }

      return prefix
    }
  }
}

fun main() {
  check(Solution().longestCommonPrefix(arrayOf("flower","flow","flight")) == "fl")
  check(Solution().longestCommonPrefix(arrayOf("dog","racecar","car")) == "")
  check(Solution().longestCommonPrefix(arrayOf("aca","cba")) == "")
}