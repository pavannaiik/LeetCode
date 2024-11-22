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
        return divide(lists, 0, lists.length-1);
    }
    public ListNode divide(ListNode[] lists, int left, int right){
        if(left==right) return lists[left];
        if(left < right){
            int mid = left+(right-left)/2;
            ListNode l1 = divide(lists, left, mid);
            ListNode l2 = divide(lists, mid+1, right);
            return merge(l1, l2);
        }else{
            return null;
        }

    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l1;
                l1 = point.next.next;
            }
            point = point.next;
        }
        if (l1 == null) {
            point.next = l2;
        } else {
            point.next = l1;
        }
        return head.next;
    }
    
}