package algorightm.linklist;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 * 单链表反转
 */
public class Reverse {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        head.next = null;
        ListNode r;
        while(q!=null){
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p = head.next;
        ListNode q;
        head.next = null;
        while(p!=null){
            q = p.next;
            p.next = head;
            head = p;
            p = q;
        }
        return head;
    }

    /**
     * the solution from leetcode
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * the solution from leetcode
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
