package leetcode

/**
 * # 200. Number of Islands
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * ## Example 1:
 * ```
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * ```
 *
 * ## Example 2:
 * ```
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * ```
 *
 * ## Constraints:
 * ```
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * ```
 */
@Suppress("ClassName")
class `200_Number_Of_Islands` {
  class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
      if (grid.isEmpty()) return 0

      var num = 0
      for (i in grid.indices)
        for (j in grid[0].indices) {
          if (grid[i][j] == '1') {
            ++num
            dfs(grid, i, j)
          }
        }

      return num
    }

    private fun dfs(grid: Array<CharArray>, r: Int, c: Int) {
      if (r < 0 || c < 0 || r >= grid.size || c >= grid[0].size || grid[r][c] == '0') return

      grid[r][c] = '0'
      dfs(grid, r - 1, c)
      dfs(grid, r + 1, c)
      dfs(grid, r, c - 1)
      dfs(grid, r, c + 1)
    }
  }
}