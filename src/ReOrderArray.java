import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        int[] result = new int[array.length];
        int length = result.length - 1;
        int i = 0;
        int j = length;
        int start = 0;
        int end = length;
        while (start <= end) {
            while (i <= length && array[i] % 2 == 0) {
                ++i;
            }
            while (j >= 0 && array[j] % 2 == 1) {
                --j;
            }

            if (i <= length) {
                result[start++] = array[i++];
            }
            if (j >= 0) {
                result[end--] = array[j--];
            }
        }

        System.arraycopy(result, 0, array, 0, length + 1);
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5};
        new ReOrderArray().reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
