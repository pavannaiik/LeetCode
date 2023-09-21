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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode slow = head;
        ListNode prev = null;
        int i=1;
        while( left > 1){
            prev = slow;
            slow=slow.next;
            left--;
            right--;
        }
        
        ListNode res = prev;
        ListNode temp = slow;
        while( right > 0 ){
            ListNode node = slow.next;
            slow.next = prev;
            prev = slow;
            slow = node;
            right--;
        }
        if(res !=null)
        res.next = prev;
        else
        head = prev;
        temp.next = slow;
        return head;
    }
}