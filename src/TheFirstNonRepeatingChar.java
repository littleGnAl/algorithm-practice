/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class TheFirstNonRepeatingChar {

    private StringBuilder sb = new StringBuilder();

    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        String str = sb.toString();
        if (str.isEmpty()) return '#';

        char[] strArr = str.toCharArray();
        int[] hash = new int[256];
        for (char c : strArr) {
            hash[c]++;
        }

        for (char c : strArr) {
            if (hash[c] == 1) return c;
        }

        return '#';
    }

    public static void main(String[] args) {
        TheFirstNonRepeatingChar fc = new TheFirstNonRepeatingChar();
        char[] input = "go".toCharArray();
        for (char c : input) {
            fc.Insert(c);
        }
        // g
        System.out.println(fc.FirstAppearingOnce());
    }
}
