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
        ListNode cur = new ListNode(0);
        ListNode result = cur;
        for(ListNode list: lists){
            if(list !=null)
                pq.add(list);
        }
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            cur.next = new ListNode(temp.val);
            ListNode nextTemp = temp.next;
            if(nextTemp !=null) pq.add(nextTemp);
            cur = cur.next;
        }
        return result.next;

    }
}