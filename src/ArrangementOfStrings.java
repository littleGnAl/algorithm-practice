import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class ArrangementOfStrings {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) return result;
        Permutation(result, str.toCharArray(), 0);
        Collections.sort(result);

        return result;
    }

    void Permutation(ArrayList<String> result, char[] cs, int start) {
        if (start == cs.length - 1) {
            String s = String.valueOf(cs);
            if (!result.contains(s)) {
                result.add(s);
            }
        } else {
            for (int i = start; i < cs.length; i++) {
                swap(cs, start, i);
                Permutation(result, cs, start + 1);
                // Reset
                swap(cs, start, i);
            }
        }


    }

    void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }

    public static void main(String[] args) {
        ArrayList<String> r = new ArrangementOfStrings().Permutation("abc");
        System.out.println(r.toString());

        ArrayList<String> r2 = new ArrangementOfStrings().Permutation("abcd");
        System.out.println(r2.toString());
    }
}
