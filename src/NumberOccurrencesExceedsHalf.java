/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class NumberOccurrencesExceedsHalf {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return array[0];

        int half = (array.length) / 2;
        int len = array.length;
        int num = array[0];
        int occurrences = 1;
        for (int i = 1; i < len; i++) {
            if (array[i] == num) {
                ++occurrences;
            } else {
                --occurrences;
            }

            if (occurrences == 0) {
                num = array[i];
                occurrences = 1;
            }
        }

        occurrences = 0;
        for (int value : array) {
            if (value == num) {
                ++occurrences;
            }
        }

        return occurrences > half ? num : 0;
    }

    public static void main(String[] args) {
        int r = new NumberOccurrencesExceedsHalf().MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
        System.out.println(r);

        int r2 = new NumberOccurrencesExceedsHalf().MoreThanHalfNum_Solution(new int[]{4, 2, 1, 4, 2, 4});
        System.out.println(r2);
    }
}
