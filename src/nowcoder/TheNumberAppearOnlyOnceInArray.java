package nowcoder;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 */
public class TheNumberAppearOnlyOnceInArray {

    public void FindNumsAppearOnce(int[] array, int num1[] , int num2[]) {
        if (array == null || array.length == 0) return;
        int len = array.length;
        if (len == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }

        int bitResult = 0;
        for (int value : array) {
            bitResult ^= value;
        }

        int index = findFirst1(bitResult);
        for (int i = 0; i < len; i++) {
            if (isBit1(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    private int findFirst1(int bitResult) {
        int index = 0;
        while (((bitResult & 1) == 0) && index < 32) {
            bitResult >>= 1;
            ++index;
        }

        return index;
    }

    private boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 2, 3 };
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new TheNumberAppearOnlyOnceInArray().FindNumsAppearOnce(array, num1, num2);
        // 1, 4
        System.out.println("num1 : " + num1[0] + ", num2 : " + num2[0]);

        int[] array2 = { 1, 2, 3, 4, 2, 4 };
        num1 = new int[1];
        num2 = new int[1];
        new TheNumberAppearOnlyOnceInArray().FindNumsAppearOnce(array2, num1, num2);
        // 1, 3
        System.out.println("num1 : " + num1[0] + ", num2 : " + num2[0]);
    }
}
