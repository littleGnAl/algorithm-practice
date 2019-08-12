/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class TheKthNodeInTheListFromTail {
    final static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (k < 1 || head == null) return null;

        ListNode p = head;
        for (int i = 1; i < k; i++) {
            if (p.next != null) {
                p = p.next;
            } else {
                return null;
            }
        }

        while (p.next != null) {
            head = head.next;
            p = p.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        System.out.println(new TheKthNodeInTheListFromTail().FindKthToTail(l1, 2).val);
//        System.out.println(new TheKthNodeInTheListFromTail().FindKthToTail(l1, 0).val);
    }
}
