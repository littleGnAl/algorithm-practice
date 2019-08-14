/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class PostOrderTraversalSequenceOfBST {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;

        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int root = sequence[end];

        int i = start;
        while (sequence[i] < root) {
            ++i;
        }

        int j = i;
        for (; j < end; j++) {
            if (sequence[j] < root) return false;
        }

        boolean left = VerifySquenceOfBST(sequence, start, i - 1);
        boolean right = VerifySquenceOfBST(sequence, i, end - 1);

        return left && right;
    }

    public static void main(String[] args) {
        System.out.println(new PostOrderTraversalSequenceOfBST().VerifySquenceOfBST(new int[] {2, 4, 3, 8, 12, 9, 6}));
    }
}
