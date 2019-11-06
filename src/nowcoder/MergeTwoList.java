package nowcoder;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoList {
    final static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) return list2;
        if (list2 == null && list1 != null) return list1;
        if (list1 == null) return null;

        ListNode p = list1;
        ListNode q = list2;
        ListNode newNode;
        if (p.val <= q.val) {
            newNode = p;
            p = p.next;
        } else {
            newNode = q;
            q = q.next;
        }
        ListNode head = newNode;

        while (p != null && q != null) {
            if (p.val <= q.val) {
                newNode.next = p;
                p = p.next;
            } else {
                newNode.next = q;
                q = q.next;
            }

            newNode = newNode.next;
        }

        if (p == null) {
            newNode.next = q;
        } else {
            newNode.next = p;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(13);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode ll1 = new ListNode(3);
        ListNode ll2 = new ListNode(4);
        ListNode ll3 = new ListNode(7);
        ListNode ll4 = new ListNode(10);
        ListNode ll5 = new ListNode(17);
        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = ll4;
        ll4.next = ll5;

        ListNode result = new MergeTwoList().Merge(l1, ll1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
