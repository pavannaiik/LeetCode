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
        ListNode ans = new ListNode(0);
        ListNode prev = ans;
        int carry=0;
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            ans.next = new ListNode(sum%10);
            ans = ans.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
             int sum = l1.val  + carry;
             carry = sum/10;
             ans.next = new ListNode(sum%10);
             ans = ans.next;
             l1=l1.next;
        }
        while(l2!=null){
             int sum = l2.val  + carry;
             carry = sum/10;
             ans.next = new ListNode(sum%10);
             ans = ans.next;
             l2=l2.next;
        }
        if(carry!=0){
            ans.next = new ListNode(carry);
            ans = ans.next;
        }
        return prev.next;
    }
}