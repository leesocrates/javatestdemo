package algorightm.linklist;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class mergeToSortedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(8);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(9);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
//        ListNode result = mergeTwoLists(listNode, listNode3);
        ListNode result = mergeTwoLists1(listNode,listNode3);
        while (result!=null){
            System.out.println("val is : "+ result.val);
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode head = null;
        while(l1!=null && l2!=null){
            ListNode temp;
            if(l1.val<=l2.val){
                temp = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }
            if(l3==null){
                l3 = temp;
                head = l3;
            } else {
                l3.next = temp;
                l3 = temp;
            }
        }
        if(l1!=null){
            if(l3!=null){
                l3.next = l1;
            } else {
                l3 = l1;
                head = l3;
            }
        } else if (l2!=null){
            if(l3!=null){
                l3.next = l2;
            } else {
                l3 = l2;
                head = l3;
            }
        }
        return head;
    }

    /**
     * 引入了head哨兵节点后，省去了很多的判空，最后返回的时候返回哨兵节点的下一个节点
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if(l1!=null){
            l3.next = l1;
        } else if (l2!=null){
            l3.next = l2;
        }
        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        } else if (l2 == null){
            return l1;
        }
        if(l1.val<=l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
