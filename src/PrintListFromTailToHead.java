import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {

    final static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) return new ArrayList<>();
        ListNode p = listNode;
        ListNode q = p.next;
        p.next = null;
        ListNode r;

        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }

        ArrayList<Integer> output = new ArrayList<>();
        ListNode outputListNode = p;
        while (outputListNode != null) {
            output.add(outputListNode.val);
            outputListNode = outputListNode.next;
        }

        return output;
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

        System.out.println(new PrintListFromTailToHead().printListFromTailToHead(l1));
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead(null));
    }
}
