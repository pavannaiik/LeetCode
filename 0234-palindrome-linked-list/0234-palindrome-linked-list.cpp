/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        ListNode* slow=head;
        ListNode* fast=head;
        while(fast!=NULL && fast->next!=NULL){
            slow=slow->next;
            fast=fast->next->next;
        }
        slow=reverse(slow,NULL);
        while(slow!=NULL){
            if(slow->val !=head->val){
                return false;
            }
            slow=slow->next;
            head=head->next;
        }
        return true;
    }
    ListNode* reverse(ListNode* cur,ListNode* prev){
        if(cur==NULL){
            return prev;
        }
        ListNode* t=cur->next;
        cur->next = prev;
        return reverse(t, cur);
    }
};