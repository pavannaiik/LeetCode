class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseRecur(head,null);
    }
    public ListNode reverseRecur(ListNode cur,ListNode prev){
        if(cur==null){
            return prev;
        }
        ListNode next = cur.next;
        cur.next = prev;
        return reverseRecur(next, cur);
    }
}