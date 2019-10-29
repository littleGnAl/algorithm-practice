/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class AStringRepresentingANumericValue {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;
        int len = str.length;

        int start = 0;
        if (str[0] == '+' || str[0] == '-') start = 1;
        int i = start;
        boolean canRepresentDot = true;
        while (i < len) {
            if (i > start && (str[i] == 'e' || str[i] == 'E')) {
                canRepresentDot = false;
                if (i + 1 < len && (str[i + 1] == '-' || str[i + 1] == '+' || (str[i + 1] >= '1' && str[i + 1] <= '9'))) {
                    i += 2;
                    continue;
                } else {
                    return false;
                }
            }

            if (str[i] == '.') {
                if (canRepresentDot) {
                    canRepresentDot = false;
                } else {
                    return false;
                }
                ++i;
                continue;
            }

            if ((i > start && str[i] >= '0' && str[i] <= '9') || (str[i] >= '1' && str[i] <= '9')) {
                ++i;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // true
        System.out.println(new AStringRepresentingANumericValue().isNumeric("+100".toCharArray()));
        // true
        System.out.println(new AStringRepresentingANumericValue().isNumeric("5e2".toCharArray()));
        // true
        System.out.println(new AStringRepresentingANumericValue().isNumeric("-123".toCharArray()));
        // true
        System.out.println(new AStringRepresentingANumericValue().isNumeric("3.1416".toCharArray()));
        // true
        System.out.println(new AStringRepresentingANumericValue().isNumeric("-1E-16".toCharArray()));
        // true
        System.out.println(new AStringRepresentingANumericValue().isNumeric("123.45e+6".toCharArray()));
        // false
        System.out.println(new AStringRepresentingANumericValue().isNumeric("12e".toCharArray()));
        // false
        System.out.println(new AStringRepresentingANumericValue().isNumeric("1a3.14".toCharArray()));
        // false
        System.out.println(new AStringRepresentingANumericValue().isNumeric("1.2.3".toCharArray()));
        // false
        System.out.println(new AStringRepresentingANumericValue().isNumeric("+-5".toCharArray()));
        // false
        System.out.println(new AStringRepresentingANumericValue().isNumeric("12e+4.3".toCharArray()));
    }
}
