package nowcoder;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
final class TwoDimensionalArraySearch {

    public boolean Find(int target, int[][] source) {
        int maxRow = source.length - 1;
        int maxColumn = source[0].length - 1;
        int row = 0;
        int column = maxColumn;
        while (row <= maxRow && column >= 0) {
            if (source[row][column] == target) {
                return true;
            } else if (source[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] bbb =
                {
                    {1, 2, 8, 9},
                    {2, 4, 9, 12},
                    {4, 7, 10, 13},
                    {6, 8, 11, 15}
                };
        System.out.println(new TwoDimensionalArraySearch().Find(5, bbb));
    }
}
