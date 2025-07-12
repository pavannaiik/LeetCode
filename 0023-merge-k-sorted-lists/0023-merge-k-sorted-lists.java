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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:lists) {
            if(node !=null)
            pq.add(node);
    }
        ListNode ans = new ListNode(0);
        ListNode prev = ans;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            ans.next = new ListNode(temp.val);
            ans=ans.next;
            if(temp.next!=null) pq.add(temp.next);
        }
        return prev.next;
    }
}