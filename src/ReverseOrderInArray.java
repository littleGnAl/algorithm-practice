/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 *
 * 数据范围：
 *
 * 	对于%50的数据,size<=10^4
 * 	对于%75的数据,size<=10^5
 * 	对于%100的数据,size<=2*10^5
 *
 * 示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 *
 * 输出
 * 7
 *
 */
public class ReverseOrderInArray {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;

        return inverseSubPair(array, 0, array.length - 1);
    }

    int inverseSubPair(int[] arr, int start, int end) {
        if (start >= end) return 0;
        int mid = (start + end) / 2;
        int leftCount = inverseSubPair(arr, start, mid);
        int rightCount = inverseSubPair(arr, mid + 1, end);
        int i = mid, j = end;
        int[] copy = new int[end - start + 1];
        int copyIndex = end - start;
        int count = 0;

        while (i >= start && j >= mid + 1) {
            if (arr[i] > arr[j]) {
                copy[copyIndex--] = arr[i--];
                count += j - mid;
                if (count > 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[copyIndex--] = arr[j--];
            }
        }

        while (i >= start) {
            copy[copyIndex--] = arr[i--];
        }

        while (j >= mid + 1) {
            copy[copyIndex--] = arr[j--];
        }

        for (i = 0; start <= end;) {
            arr[start++] = copy[i++];
        }

        return (leftCount + rightCount + count) % 1000000007;
    }

    public static void main(String[] args) {
        // 7
        System.out.println(new ReverseOrderInArray().InversePairs(new int[] {1, 2, 3, 4, 5, 6, 7, 0}));
    }
}
