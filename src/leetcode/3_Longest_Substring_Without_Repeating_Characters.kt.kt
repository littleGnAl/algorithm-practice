package leetcode

/**
 * # 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * ## Example 1:
 * ```
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * ```
 *
 * ## Example 2:
 * ```
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * ```
 *
 * ## Example 3:
 * ```
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * ```
 *
 * ## Example 4:
 * ```
 * Input: s = ""
 * Output: 0
 * ```
 *
 * ## Constraints:
 * ```
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * ```
 */
@Suppress("ClassName")
class `3_Longest_Substring_Without_Repeating_Characters` {
  class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
      val set = mutableSetOf<Char>()
      var res = 0
      var left = 0
      var right = -1
      val len = s.length

      while (left < len) {
        if (right + 1 < len && !set.contains(s[right + 1])) {
          set.add(s[right + 1])
          ++right
        } else {
          set.remove(s[left])
          ++left
        }

        res = kotlin.math.max(res, right - left + 1)
      }

      return res
    }
  }
}