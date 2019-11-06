package nowcoder;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class PushPopSequenceOfStack {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length || pushA.length == 0) return false;

        int pushIndex = 0;
        int popIndex = 0;
        int size = popA.length;
        Stack<Integer> stack = new Stack<>();

        while (pushIndex < size) {
            stack.push(pushA[pushIndex++]);

            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                ++popIndex;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        int[] popA2 = {4, 3, 5, 1, 2};
        int[] popA3 = {1, 2, 3, 4, 5};
        System.out.println(new PushPopSequenceOfStack().IsPopOrder(pushA, popA));
        System.out.println(new PushPopSequenceOfStack().IsPopOrder(pushA, popA2));
        System.out.println(new PushPopSequenceOfStack().IsPopOrder(pushA, popA3));
    }
}
