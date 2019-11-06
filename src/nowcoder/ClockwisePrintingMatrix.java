package nowcoder;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class ClockwisePrintingMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 0) return null;
        int maxColumnLength = matrix[0].length - 1, maxRowLength = matrix.length - 1;
        int minColumnLength = 0, minRowLength = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (minRowLength <= maxRowLength && minColumnLength <= maxColumnLength) {
            for (int i = minColumnLength; i <= maxColumnLength; i++) {
                result.add(matrix[minRowLength][i]);
            }

            for (int i = minRowLength + 1; i <= maxRowLength; i++) {
                result.add(matrix[i][maxColumnLength]);
            }

            if (minRowLength != maxRowLength) {
                for (int i = maxColumnLength - 1; i >= minColumnLength; i--) {
                    result.add(matrix[maxRowLength][i]);
                }
            }

            if (minColumnLength != maxColumnLength) {
                for (int i = maxRowLength - 1; i > minRowLength; i--) {
                    result.add(matrix[i][minColumnLength]);
                }
            }

            ++minRowLength;
            --maxColumnLength;
            --maxRowLength;
            ++minColumnLength;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array =
                {
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}

                };
        ArrayList<Integer> r = new ClockwisePrintingMatrix().printMatrix(array);
        for (Integer i : r) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[][] array2 =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}

                };
        ArrayList<Integer> r2 = new ClockwisePrintingMatrix().printMatrix(array2);
        for (Integer i : r2) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[][] array3 =
                {
                        {1, 2},
                        {5, 6},

                };
        ArrayList<Integer> r3 = new ClockwisePrintingMatrix().printMatrix(array3);
        for (Integer i : r3) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[][] array4 =
                {
                        {1, 2, 3},
                        {5, 6, 7},

                };
        ArrayList<Integer> r4 = new ClockwisePrintingMatrix().printMatrix(array4);
        for (Integer i : r4) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[][] array5 =
                {
                        {1},
                        {2},
                        {3},
                        {4},
                        {5}

                };
        ArrayList<Integer> r5 = new ClockwisePrintingMatrix().printMatrix(array5);
        for (Integer i : r5) {
            System.out.print(i + " ");
        }
    }
}
