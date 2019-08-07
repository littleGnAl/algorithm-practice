/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        if (str.length() == 0) return str.toString();
        int length = str.length() - 1;
        int start = 0;
        while (start <= length) {
            int i = str.indexOf(" ", start);
            if (i == -1) break;
            str.replace(i, i + 1, "%20");
            int preStart = start;
            start += i;
            if (preStart == start) break;
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceSpace().replaceSpace(new StringBuffer("We Are Happy")));
        System.out.println(new ReplaceSpace().replaceSpace(new StringBuffer(" ")));
        System.out.println(new ReplaceSpace().replaceSpace(new StringBuffer("")));
    }
}
