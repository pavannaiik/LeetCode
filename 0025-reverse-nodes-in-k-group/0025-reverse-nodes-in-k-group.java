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
        if(head==null||k==1) return head;
        ListNode node=head;
        int len=0;
            while(node!=null){
                len++;
                node=node.next;
            }
        ListNode temp=new ListNode(0);
        temp.next=head;
       ListNode cur=temp,nex=temp,pre=temp;
        while(len>=k){
            cur=pre.next;
            nex=cur.next;
            for(int i=1;i<k;i++){
                cur.next=nex.next;
                nex.next=pre.next;
                pre.next=nex;
                nex=cur.next;
            }
            pre=cur;
            len-=k;
        }
        return temp.next;
    }
}