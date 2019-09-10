/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstCharAppearOnlyOnce {
    public int FirstNotRepeatingChar(String str) {
        char[] arr = str.toCharArray();
        int index = -1;
        int appearTimes = 0;
        char tempChar = arr[0];

        for (int i = 0; i < arr.length;) {
            if (tempChar == arr[i]) {
                ++appearTimes;
            }
        }

        for (int i = 0; i < arr.length;) {
            char temp = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == ' ')
                    continue;

                if (temp == arr[j]) {
                    arr[j] = ' ';
                    if (arr[i] != ' ') {
                        arr[i] = ' ';
                    }
                }

            }
        }


        return 0;
    }
}
