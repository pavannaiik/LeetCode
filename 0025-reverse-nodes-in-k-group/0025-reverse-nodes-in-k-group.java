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
        //1. test weather we have more then k node left, if less then k node left we just return head 
        ListNode node = head;
        int count = 0;
        while (count < k) { 
            if(node == null)return head;
            node = node.next;
            count++;
        }
    // 2.reverse k node at current level 
       ListNode cur = reverseKGroup(node, k); //pre node point to the the answer of sub-problem 
        while (count > 0) {  
            ListNode temp = head.next; 
            head.next = cur; 
            cur = head; 
            head = temp;
            count = count - 1;
        }
        return cur;

    }
}