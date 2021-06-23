package leetcode

/**
 * # 93. Restore IP Addresses
 * Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.
 *
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 *
 * ## Example 1:
 * ```
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * ```
 *
 * ## Example 2:
 * ```
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * ```
 *
 * ## Example 3:
 * ```
 * Input: s = "1111"
 * Output: ["1.1.1.1"]
 * ```
 *
 * ## Example 4:
 * ```
 * Input: s = "010010"
 * Output: ["0.10.0.10","0.100.1.0"]
 * ```
 *
 * ## Example 5:
 * ```
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * ```
 *
 * ## Constraints:
 * ```
 * 0 <= s.length <= 3000
 * s consists of digits only.
 * ```
 */
@Suppress("ClassName")
class `93_Restore_IP_Addresses` {
  class Solution {
    fun restoreIpAddresses(s: String): List<String> {
      val len = s.length
      val res = mutableListOf<String>()

      if (len < 4 || len > 12) return res

      val path = mutableListOf<String>()
      dfs(s, 0, len, 0, path, res)
      return res
    }

    private fun ipSegment(s: String, left: Int, right: Int): Int {
      val len = right - left + 1

      if (len > 1 && s[left] == '0') {
        return -1
      }

      var res = 0
      for (i in left..right) {
        res = res * 10 + (s[i] - '0')
      }

      if (res > 255) return -1

      return res
    }

    private fun dfs(
        s: String,
        splitTimes: Int,
        len: Int,
        begin: Int,
        path: MutableList<String>,
        res: MutableList<String>
    ) {
      if (begin == len) {
        if (splitTimes == 4) {
          res.add(path.joinToString(separator = "."))
        }

        return
      }

      if (len - begin < (4 - splitTimes) || len - begin > 3 * (4 - splitTimes)) {
        return
      }

      for (i in 0 until 3) {
        if (begin + i >= len) break

        val ipSegment = ipSegment(s, begin, begin + i)
        if (ipSegment != -1) {
          path.add(ipSegment.toString())
          dfs(s, splitTimes + 1, len, begin + i + 1, path, res)
          path.removeAt(path.size - 1)
        }
      }
    }
  }
}