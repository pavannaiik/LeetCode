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
       int size = lists.length;
        int interval =1;
        
        while(interval < size){
            
            for(int i=0;i<size-interval;i+=2*interval){
                lists[i]=mergeTwoSortedLists(lists[i],lists[i+interval]);
            }
            interval*=2;
        }
        return size>0?lists[0]:null;
        
    }
    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2){
        ListNode temp = new ListNode(0);
        ListNode dummy = temp;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                dummy.next=l1;
                l1=l1.next;
            }else{
                dummy.next=l2;
                l2=l2.next;
            }
            dummy = dummy.next;
        }
        if(l1!=null){
            dummy.next = l1;
        }
        if(l2!=null){
            dummy.next = l2;
        }
        return temp.next;
    }
}