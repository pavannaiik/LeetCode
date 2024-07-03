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
    public boolean isPalindrome(ListNode head) {
        ListNode slow =  head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow, null);
        while(slow!=null ){
            if(slow.val !=head.val){
                return false;
            }
            slow= slow.next;
            head = head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode curr, ListNode prev){
        if(curr==null){
            return prev;
        }
        ListNode temp= curr.next;
        curr.next= prev;
        return reverse(temp, curr);
    }
}