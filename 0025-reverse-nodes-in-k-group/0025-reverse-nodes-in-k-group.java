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
        int len =0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res, prev = res, nex=res;
        while(len>=k){
            cur = prev.next;
            nex = cur.next;
            for(int i=1;i<k;i++){
                cur.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = cur.next;
            }
            prev = cur;
            len-=k;
        }
        return res.next;
    }
}