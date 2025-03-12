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
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        
        ListNode reversed  = reverse(slow.next, null);
        slow.next = null;
        while(reversed!=null){
            ListNode temp = head.next;
            ListNode tempRev = reversed.next;
            head.next = reversed;
            reversed.next = temp;
            head = head.next.next;
            reversed = tempRev;
        }

    }
    public ListNode reverse(ListNode node, ListNode prev){
        if(node == null) return prev;
        ListNode cur = node.next;
        node.next = prev;
        return reverse(cur, node);
    }
}