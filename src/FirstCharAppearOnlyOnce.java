/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstCharAppearOnlyOnce {
    public int FirstNotRepeatingChar(String str) {
        char[] arr = str.toCharArray();
        int[] hashArr = new int['z' + 1];

        for (char c : arr) {
            hashArr[c]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (hashArr[arr[i]] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstCharAppearOnlyOnce().FirstNotRepeatingChar("abcDabc"));
        System.out.println(new FirstCharAppearOnlyOnce().FirstNotRepeatingChar("google"));
        System.out.println(new FirstCharAppearOnlyOnce().FirstNotRepeatingChar(
                "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));
    }
}
