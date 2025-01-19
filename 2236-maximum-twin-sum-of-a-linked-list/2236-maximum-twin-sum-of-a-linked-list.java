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
    public int pairSum(ListNode head) {
        Stack<Integer>stack = new Stack<>();
        int n =0;
        ListNode cur = head;
        while(cur!=null){
            cur=cur.next;
            n++;
        }
        int len =0;
        ListNode temp = head;
        int maxi=0;
        while(temp!=null){
            if(len < n/2){
                stack.add(temp.val);
            }else{
                maxi=Math.max(maxi, stack.pop()+temp.val);
            }
            len++;
            temp=temp.next;
        }
        return maxi;
    }
}