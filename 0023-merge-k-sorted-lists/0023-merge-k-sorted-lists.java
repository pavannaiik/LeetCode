
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
    public ListNode mergeLists(ListNode[] lists, int leftIndex, int rightIndex){
        if(leftIndex==rightIndex) return lists[leftIndex];
        if(leftIndex>rightIndex) return null;
        int mid = leftIndex + (rightIndex-leftIndex)/2;
        ListNode leftNode = mergeLists(lists, leftIndex, mid);
        ListNode rightNode = mergeLists(lists, mid+1, rightIndex);
        return merge(leftNode, rightNode);
    }
    public ListNode merge(ListNode leftNode, ListNode rightNode){
        ListNode cur = new ListNode(0);
        ListNode result = cur;
        while(leftNode!=null && rightNode!=null){
            if(leftNode.val <= rightNode.val){
                cur.next = new ListNode(leftNode.val);
                leftNode = leftNode.next;
            }else{
                cur.next = new ListNode(rightNode.val);
                rightNode=rightNode.next;
            }
            cur=cur.next;
        }
        while(leftNode!=null){
            cur.next=new ListNode(leftNode.val);
            cur=cur.next;
            leftNode=leftNode.next;
        }
        while(rightNode!=null){
            cur.next =new ListNode(rightNode.val);
            cur=cur.next;
            rightNode=rightNode.next;
        }
        return result.next;
    }
}
