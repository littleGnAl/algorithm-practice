package nowcoder;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FirstCommonNodeInList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        int len1 = 1, len2 = 1;
        while (p1.next != null) {
            p1 = p1.next;
            ++len1;
        }

        while (p2.next != null) {
            p2 = p2.next;
            ++len2;
        }

        if (len1 > len2) {
            int diff = len1 - len2;
            while (diff != 0) {
                pHead1 = pHead1.next;
                --diff;
            }
        } else {
            int diff = len2 - len1;
            while (diff != 0) {
                pHead2 = pHead2.next;
                --diff;
            }
        }

        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }

            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // 2
        System.out.println(new FirstCommonNodeInList().FindFirstCommonNode(n1, n2));
    }
}
