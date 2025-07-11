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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode prev = temp;
        int carry =0;
        while(l1 != null && l2 != null){
            int curSum =  carry + l1.val + l2.val;
            l1=l1.next;
            l2=l2.next;
            carry = curSum/10;
            temp.next = new ListNode(curSum%10);
            temp = temp.next;
        }
        while(l1!=null){
            int curSum =  carry + l1.val ;
            l1=l1.next;
            carry = curSum/10;
            temp.next = new ListNode(curSum%10);
            temp = temp.next;
        }
        while(l2!=null){
            int curSum =  carry + l2.val ;
            l2=l2.next;
            carry = curSum/10;
            temp.next = new ListNode(curSum%10);
            temp = temp.next;
        }
        if(carry > 0) temp.next = new ListNode(carry);
        temp = temp.next;
        return prev.next;
    }
}