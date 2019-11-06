package nowcoder;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class RegularExpressionMatching {
    public boolean match(char[] str, char[] pattern) {
        if (str == null) return false;
        if (pattern == null) return false;

        return isMatch(str, 0, pattern, 0);
    }

    boolean isMatch(char[] str, int si, char[] pattern, int pi) {
        int sLen = str.length;
        int pLen = pattern.length;
        if (si == sLen && pi == pLen) return true;
        if (pi == pLen) return false;

        if (pi + 1 < pLen && pattern[pi + 1] == '*') {
            if (si < sLen && (str[si] == pattern[pi] || pattern[pi] == '.')) {
                return isMatch(str, si, pattern, pi + 2) ||
                        isMatch(str, si + 1, pattern, pi + 2) ||
                        isMatch(str, si + 1, pattern, pi);
            } else {
                return isMatch(str, si, pattern, pi + 2);
            }
        }

        if (si < sLen && (str[si] == pattern[pi] || pattern[pi] == '.')) {
            return isMatch(str, si + 1, pattern, pi + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        // true
        System.out.println(new RegularExpressionMatching().match("".toCharArray(), "".toCharArray()));
        // true
        System.out.println(new RegularExpressionMatching().match("aaa".toCharArray(), "a.a".toCharArray()));
        // true
        System.out.println(new RegularExpressionMatching().match("aaa".toCharArray(), "ab*ac*a".toCharArray()));
        // false
        System.out.println(new RegularExpressionMatching().match("aaa".toCharArray(), "aa.a".toCharArray()));
        // false
        System.out.println(new RegularExpressionMatching().match("aaa".toCharArray(), "ab*a".toCharArray()));
        // true
        System.out.println(new RegularExpressionMatching().match("".toCharArray(), ".*".toCharArray()));
        // true
        System.out.println(new RegularExpressionMatching().match("a".toCharArray(), ".".toCharArray()));
        // true
        System.out.println(new RegularExpressionMatching().match("a".toCharArray(), "ab*".toCharArray()));
    }
}
