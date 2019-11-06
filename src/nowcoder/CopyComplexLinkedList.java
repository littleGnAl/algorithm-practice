package nowcoder;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CopyComplexLinkedList {
    final static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;

        RandomListNode head = pHead;
        // A -> A' -> B -> B' -> C -> C'
        while (head != null) {
            RandomListNode node = new RandomListNode(head.label);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }

        head = pHead;
        while (head != null) {
            head.next.random = head.random == null ? null : head.random.next;
            head = head.next.next;
        }

        head = pHead;
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode node = head.next;
            head.next = node.next;
            node.next = node.next == null ? null : node.next.next;
            head = head.next;
        }

        return newHead;
    }

    static boolean isEqual(RandomListNode node1, RandomListNode node2) {
        while (node1 != null && node2 != null) {
            if (node1.label != node2.label) return false;
            if (node1.random != null && node1.random.label != node2.random.label) return false;
            node1 = node1.next;
            node2 = node2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r1.random = r3;
        r2.random = r4;

        System.out.println(isEqual(new CopyComplexLinkedList().Clone(r1), r1));
    }
}
