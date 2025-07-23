/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        while(true){
            ListNode kth = getKListNode(prevGroupEnd, k);
            if(kth == null) break;
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            ListNode prev = kth.next;
            ListNode cur = groupStart;
            while(cur!=nextGroupStart ){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur =temp;
            }
            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart;
        }
        return dummy.next;
    }
    public ListNode getKListNode(ListNode start, int k){
        while(start!=null && k-- >0) start=start.next;
        return start;
    }
}