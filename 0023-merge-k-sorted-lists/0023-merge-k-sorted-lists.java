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
       Queue<ListNode> minHeap = new PriorityQueue(new Comparator<ListNode>(){
           @Override
           public int compare(ListNode l1, ListNode l2){
               return l1.val -l2.val;
           }
       });
        for(ListNode lis:lists){
            if(lis!=null)
            minHeap.offer(lis);
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!minHeap.isEmpty()){
            tail.next = minHeap.poll();
            tail =tail.next;
            if(tail.next!=null) minHeap.offer(tail.next);
        }
        return head.next;
        
    }
    
}