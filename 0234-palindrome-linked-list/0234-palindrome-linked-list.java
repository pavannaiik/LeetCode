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
    ListNode frontPointer;
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return backtrack(head);
    }
    public boolean backtrack(ListNode cur){
        if(cur!=null){
            if(!backtrack(cur.next)) return false;
            if(frontPointer.val != cur.val) return false;
            frontPointer=frontPointer.next;
        }
        return true;
    }
}