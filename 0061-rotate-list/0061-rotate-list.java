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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // find length of list
        ListNode dummy = head;
        int count = 1;
        while (dummy.next != null) {
            count++;
            dummy = dummy.next;
        }
        // last dummy node pointed to first node of head to make circular linkedList
        dummy.next = head;
        // rotate your linkedList
        k = k % count;
        k = count - k;
        while (k-- > 0) {
            dummy = dummy.next;
        }
        // make the node head and break connection
        head = dummy.next;
        dummy.next = null;
        return head;
    }
}