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
        //use priority queue to sort the list list 
       Queue<ListNode> minHeap = new PriorityQueue(new Comparator<ListNode>(){
           @Override
           public int compare(ListNode l1, ListNode l2){
               return l1.val -l2.val;
           }
       });
        //insert all the linkedLists into minHeap it will sort in asc order
        for(ListNode lis:lists){
            if(lis!=null)
            minHeap.offer(lis);
        }
        
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!minHeap.isEmpty()){
            // now pop the top linked list and take the first value into tail then push the linked list that starts from second element of poped list. when we push that into heap it will sort again in asc which givens us minimum value on the top
            tail.next = minHeap.poll();
            tail =tail.next;
            if(tail.next!=null) minHeap.offer(tail.next);
        }
        return head.next;
        
    }
    
}