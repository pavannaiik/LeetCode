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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len =0;
        ListNode cur = head;
        ListNode temp = head;
        while(cur !=null){
            len++;
            cur = cur.next;
        }
        if(len ==0 || len ==1){
            return null;
        }
       for(int i= len ;i>n ;i--){
            if(i-1 == n){
               temp.next = temp.next.next;
                break;
            }else{
                temp =temp.next;
            }
        }
        if(len == n){
            return head.next;
        }
        return head;
    }
}