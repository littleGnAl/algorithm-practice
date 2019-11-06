package nowcoder;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class TheNumberOccurrencesInSortedList {
    public int GetNumberOfK(int[] array , int k) {
        if (array == null || array.length == 0) return 0;
        int first = getFirst(array, k, 0, array.length - 1);
        int end = getLast(array, k, 0, array.length - 1);
        if (first != -1 && end != -1) {
            return end - first + 1;
        }

        return 0;
    }

    int getFirst(int[] arr, int k, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (k <= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (start < arr.length && arr[start] == k) {
            return start;
        }

        return -1;
    }

    int getLast(int[] arr, int k, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (k >= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (end >= 0 && arr[end] == k) {
            return end;
        }

        return -1;
    }

    public static void main(String[] args) {
        // 3
        System.out.println(new TheNumberOccurrencesInSortedList().GetNumberOfK(new int[] {1, 2, 3, 3, 3, 4}, 3));
        // 4
        System.out.println(new TheNumberOccurrencesInSortedList().GetNumberOfK(new int[] {1, 3, 3, 3, 3, 4}, 3));
    }
}
