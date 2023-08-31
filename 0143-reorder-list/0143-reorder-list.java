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
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        
        ListNode reversed = reverse(slow.next);
        slow.next=null;
        
        ListNode curr = head;
        while(curr!=null && reversed!=null){
            ListNode nextCurr = curr.next;
            curr.next=reversed;
            ListNode nextReversed = reversed.next;
            reversed.next = nextCurr;
            curr = nextCurr;
            reversed = nextReversed;
        } 
        
        
    }
    
    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode cur = node;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}