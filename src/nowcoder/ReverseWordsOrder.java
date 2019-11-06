package nowcoder;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseWordsOrder {
    public String ReverseSentence(String str) {
        if (str.isEmpty()) return str;

        char[] strArr = str.toCharArray();

        int start = 0;
        while (start < strArr.length) {
            int j = start;
            while (j < strArr.length && strArr[j] != ' ') {
                ++j;
            }
            swap(strArr, start, j - 1);
            start = j + 1;
        }

        swap(strArr, 0, strArr.length - 1);

        return new String(strArr);
    }

    void swap(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        // I am a student.
        System.out.println(new ReverseWordsOrder().ReverseSentence("student. a am I"));
    }
}
