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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode temp = new ListNode(head.val);
        ListNode ans = temp;
        ListNode slow = head.next;
        while(slow!=null){
            if(slow.val != temp.val){
                temp.next = new ListNode(slow.val);
                temp=temp.next;
                slow=slow.next;
            }else slow = slow.next;
        }
        return ans;
    }
}