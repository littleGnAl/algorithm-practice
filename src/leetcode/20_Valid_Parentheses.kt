package leetcode

/**
 * # 20. Valid Parentheses
 *
 * [https://leetcode.com/problems/valid-parentheses/](https://leetcode.com/problems/valid-parentheses/)
 *
 * Given a string s containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`,
 * determine if the input string is valid.
 * An input string is valid if:
 *
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 *
 * ## Example 1:
 * ```
 * Input: s = "()"
 * Output: true
 * ```
 *
 * ## Example 2:
 * ```
 * Input: s = "()[]{}"
 * Output: true
 * ```
 *
 * ## Example 3:
 * ```
 * Input: s = "(]"
 * Output: false
 * ```
 *
 * ## Example 4:
 * ```
 * Input: s = "([)]"
 * Output: false
 * ```
 *
 * ## Example 5:
 * ```
 * Input: s = "{[]}"
 * Output: true
 * ```
 *
 * ## Constraints:
 *
 * * `1 <= s.length <= 10^4`
 * * s consists of parentheses only `'()[]{}'`.
 */
@Suppress("ClassName")
class `20_Valid_Parentheses` {
  class Solution {
    fun isValid(s: String): Boolean {
      if (s.length == 1) return false
      if (s.length % 2 != 0) return false

      val stack = java.util.Stack<Char>()
      for (i in s.indices) {
        val c = s[i]
        val openBracket = getOpenBracket(c)
        if (openBracket != null) {
          val top = if (stack.isEmpty()) "#" else stack.pop()
          if (top != openBracket) {
            return false
          }
        } else {
          stack.push(c)
        }
      }

      return stack.isEmpty()
    }

    private fun getOpenBracket(closedBracket: Char): Char? {
      return when (closedBracket) {
        ')' -> '('
        ']' -> '['
        '}' -> '{'
        else -> null
      }
    }
  }
}

fun main() {
  check(`20_Valid_Parentheses`.Solution().isValid("()"))
  check(`20_Valid_Parentheses`.Solution().isValid("()[]{}"))
  check(!`20_Valid_Parentheses`.Solution().isValid("(]"))
  check(!`20_Valid_Parentheses`.Solution().isValid("([)]"))
  check(`20_Valid_Parentheses`.Solution().isValid("{[]}"))
  check(!`20_Valid_Parentheses`.Solution().isValid("["))
  check(!`20_Valid_Parentheses`.Solution().isValid("){"))
  check(!`20_Valid_Parentheses`.Solution().isValid("[])"))
  check(`20_Valid_Parentheses`.Solution().isValid("(([]){})"))
}