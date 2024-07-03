/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA!=tempB){
            if(tempA==null){
                tempA = headB;
            }
            if(tempB==null){
                tempB=headA;
            }
            if(tempA == tempB) return tempA;
            tempA=tempA.next;
            tempB=tempB.next;
        }
        if(tempA != tempB) return new ListNode(0);
        return tempB;
    }
}