/**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        if (str.length() == 0) return str.toString();

        int spaceCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                ++spaceCount;
            }
        }

        int originIndex = str.length() - 1;
        int newLength = str.length() + 2 * spaceCount;
        str.setLength(newLength);
        int newIndex = newLength - 1;
        for (; originIndex >= 0; originIndex--) {
            if (str.charAt(originIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            } else {
                str.setCharAt(newIndex--, str.charAt(originIndex));
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceSpace().replaceSpace(new StringBuffer("We Are Happy")));
        System.out.println(new ReplaceSpace().replaceSpace(new StringBuffer(" ")));
        System.out.println(new ReplaceSpace().replaceSpace(new StringBuffer("")));
    }
}
