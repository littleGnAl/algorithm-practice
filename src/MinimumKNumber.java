import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class MinimumKNumber {

    void qSort(int[] input, int start, int end) {
        if (input == null || input.length == 0 || start >= end) {
            return;
        }

        int i = start;
        int j = end;
        int p = input[(start + end) / 2];
        while (i <= j) {
            while (input[i] < p) {
                ++i;
            }
            while (input[j] > p) {
                --j;
            }

            if (i < j) {
                int t = input[i];
                input[i] = input[j];
                input[j] = t;

                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }

        qSort(input, start, j);
        qSort(input, i, end);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || k > input.length) return result;

        qSort(input, 0, input.length - 1);

        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> result = new MinimumKNumber().GetLeastNumbers_Solution(input, 4);
        System.out.println(result.toString());
    }
}
