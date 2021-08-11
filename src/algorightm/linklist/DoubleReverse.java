package algorightm.linklist;

public class DoubleReverse {
    public class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode last;

        public DoubleNode(int data){
            this.value=data;
        }
    }
    public DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head!=null){
            next = head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return pre;
    }
}
