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
    public ListNode reverseList(ListNode head) {
        return reverseRecur(head,null);
    }
    public ListNode reverseRecur(ListNode head,ListNode prev){
        if(head==null){
            return prev;
        }
        ListNode cur = head.next;
        head.next = prev;
        return reverseRecur(cur, head);
    }
}