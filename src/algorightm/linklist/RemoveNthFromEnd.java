package algorightm.linklist;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0);
        ListNode  cur= result;
        ListNode prev = result;
        int i = 1;
        cur.next = head;
        while(cur.next!=null){
            if(i>n){
                prev = prev.next;
            }
            cur = cur.next;
            i++;
        }
        if(i>=n && prev!=null && prev.next!=null){
            prev.next = prev.next.next;
        }
        return result.next;
    }

    /**
     * 比上面的方法快，主要是少了new新对象的时间
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode cur = head;
        ListNode prev = head;
        int i = 1;
        while(cur.next!=null){
            if(i>n){
                prev = prev.next;
            }
            cur = cur.next;
            i++;
        }
        if(i>=n && prev!=null && prev.next!=null){
            if(i == n){
                ListNode temp= head.next;
                head.next = null;
                return temp;
            } else {
                prev.next = prev.next.next;
                return head;
            }

        }
        return null;
    }

    /**
     * solution from leetcode, 但是如果n大于链表的节点总数的时候，会报空指针异常
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
