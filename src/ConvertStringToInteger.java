/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 示例1
 * 输入
 * +2147483647
 *     1a33
 * 输出
 * 2147483647
 *     0
 */
public class ConvertStringToInteger {
    public int StrToInt(String str) {
        if (str.isEmpty()) return 0;

        char[] charArr = str.toCharArray();
        int startIndex = 0;
        boolean isNegative = false;
        if (charArr[0] == '+') {
            ++startIndex;
        } else if (charArr[0] == '-') {
            ++startIndex;
            isNegative = true;
        }

        long sum = 0;
        int len = charArr.length;
        for (int i = startIndex; i < len; i++) {
            char c = charArr[i];
            if (c >= '0' && c <= '9') {
//                sum = sum * 10 + (c - '0');
                sum = (sum << 1) + (sum << 3) + (c & 0xf);
            } else {
                return 0;
            }
        }



        if (isNegative) {
            sum *= -1;
        }

        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) return 0;

        return (int) sum;
    }

    public static void main(String[] args) {
        // 2147483647
        System.out.println(new ConvertStringToInteger().StrToInt("+2147483647"));
        // -2147483647
        System.out.println(new ConvertStringToInteger().StrToInt("-2147483647"));
        // 0
        System.out.println(new ConvertStringToInteger().StrToInt("2147483649"));
        // -2147483648
        System.out.println(new ConvertStringToInteger().StrToInt("-2147483648"));
        // 0
        System.out.println(new ConvertStringToInteger().StrToInt("-2147483649"));
        // 0
        System.out.println(new ConvertStringToInteger().StrToInt("1a33"));
    }
}
