import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class StackContainingMinFunction {

    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> dataStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            int top = minStack.peek();
            if (top <= node) {
                minStack.push(top);
            } else {
                minStack.push(node);
            }
        }
    }

    public void pop() {
        if (!dataStack.isEmpty() && !minStack.isEmpty()) {
            minStack.pop();
            dataStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) return 0;
        return minStack.peek();
    }
}
