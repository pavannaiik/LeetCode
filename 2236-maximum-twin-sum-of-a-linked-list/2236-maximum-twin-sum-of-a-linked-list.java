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
    public int pairSum(ListNode head) {
        ListNode cur = head;
        ListNode prev=null;
        ListNode next =null;
        ListNode fast=head;
        while(fast!=null){
            fast=fast.next.next;
            next = cur.next;
            cur.next=prev;
            prev= cur;
            cur=next;
        }
        int maxSum = 0;
        while (cur != null && prev != null) {
            maxSum = Math.max(maxSum, cur.val + prev.val);
            cur = cur.next;
            prev = prev.next;
        }

        return maxSum;
    }
}