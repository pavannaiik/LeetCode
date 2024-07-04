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
    public ListNode mergeNodes(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode temp = head;
        while(temp.next!=null){
            if(temp.next.val==0 && temp.next.next==null){
                temp.next=temp.next.next;
                break;
            }else if(temp.next.val==0){
                temp=temp.next;
            }else{
                temp.val= temp.val + temp.next.val;
                temp.next = temp.next.next;
            }
        }
        return head;
    }
}