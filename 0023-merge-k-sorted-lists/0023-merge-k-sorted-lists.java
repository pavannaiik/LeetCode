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
        for(ListNode li:lists){
            if(li!=null)
                pq.offer(li);
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!pq.isEmpty()){
            tail.next = pq.poll();
            tail=tail.next;
            if(tail.next!=null){
                pq.offer(tail.next);
            }
        }
        return head.next;
    }
}