/**
 *
 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    final static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode p = head;
        ListNode q = head.next;

        head.next = null;

        while (q != null) {
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }

        head = p;

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

        ListNode t = new ReverseList().reverseList(l1);
        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
    }
}
