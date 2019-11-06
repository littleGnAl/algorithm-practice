package nowcoder;

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

    void heapSort(int[] arr) {
        int len = arr.length - 1;
        int beginIndex = (arr.length >> 1) - 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(arr, i, len);
        }

        for (int i = len; i > 0; i--) {
            swap(arr,0, i);
            maxHeapify(arr, 0, i - 1);
        }
    }

    void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    void maxHeapify(int[] arr, int index, int len) {
        int li = (index << 1) + 1;
        int ri = li + 1;
        int cMax = li;
        if (li > len) return;
        if (ri <= len && arr[ri] > arr[li]) {
            cMax = ri;
        }
        if (arr[cMax] > arr[index]) {
            swap(arr, cMax, index);
            maxHeapify(arr, cMax, len);
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length) return result;

        int[] numbers = new int[k];
        System.arraycopy(input, 0, numbers, 0, k);

        int len = numbers.length - 1;
        int beginIndex = (numbers.length >> 1) - 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(numbers, i, len);
        }

        for (int i = k; i < input.length; i++) {
            if (input[i] < numbers[0]) {
                numbers[0] = input[i];
                maxHeapify(numbers, 0, len);
            }
        }

        for (int i : numbers) {
            result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> result = new MinimumKNumber().GetLeastNumbers_Solution(input, 4);
        System.out.println(result.toString());
    }
}
