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
        return merge(lists, 0, lists.length-1);
    }
    public ListNode merge(ListNode[] lists, int i, int n){
        if(i==n) return lists[i];
        if(i < n){
            int mid = i+(n-i)/2;
            ListNode left = merge(lists, i, mid);
            ListNode right = merge(lists, mid+1, n);
            return combine(left, right);
        }else{
            return null;
        }
    }
    public ListNode combine(ListNode left, ListNode right){
        ListNode cur = new ListNode(0);
        ListNode prev = cur;
        while(left !=null && right !=null){
            if(left.val < right.val){
                cur.next = left;
                left=left.next;
                cur=cur.next;
            }else{
                cur.next = right;
                right=right.next;
                cur=cur.next;
            }
        }
        if(left!=null){
            cur.next = left;
        }
        if(right!=null){
            cur.next = right;
        }
        return prev.next;
    }
}