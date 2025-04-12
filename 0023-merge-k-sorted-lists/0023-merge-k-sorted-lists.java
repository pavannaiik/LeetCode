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
        return mergeLists(lists, 0, lists.length-1);
    }
    public ListNode mergeLists(ListNode[] lists, int left, int right){
        if(left==right){
            return lists[left];
        }
        if(left > right ) return null;

        int mid = left+(right-left)/2;
        ListNode leftNode = mergeLists(lists, left, mid);
        ListNode rightNode = mergeLists(lists, mid+1, right);
        return merge(leftNode, rightNode);
        
        
    }
    public ListNode merge(ListNode leftNode, ListNode rightNode){
        ListNode cur = new ListNode(0);
        ListNode result = cur;
        while(leftNode!=null && rightNode!=null){
            if(leftNode.val < rightNode.val){
                cur.next = new ListNode(leftNode.val);
                leftNode = leftNode.next;
            }else{
                cur.next = new ListNode(rightNode.val);
                rightNode = rightNode.next;
            }
            cur=cur.next;
        }
        while(leftNode!=null){
            cur.next = new ListNode(leftNode.val);
            leftNode = leftNode.next;
            cur=cur.next;
        }
         while(rightNode!=null){
            cur.next = new ListNode(rightNode.val);
            rightNode = rightNode.next;
            cur=cur.next;
        }
        return result.next;
    }
}