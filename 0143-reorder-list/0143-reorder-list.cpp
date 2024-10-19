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
    void reorderList(ListNode* head) {
        ListNode* slow=head;
        ListNode* fast=head;
        while(fast!=NULL && fast->next!=NULL){
            slow=slow->next;
            fast=fast->next->next;
        }
        ListNode* second= reverse(slow->next,NULL);
        slow->next=NULL;
        //merge two list head and second
        ListNode* first=head;
        while(second!=NULL){
            ListNode* temp1=first->next;
            ListNode* temp2=second->next;
            first->next=second;
            second->next=temp1;
            first=temp1;
            second=temp2;
        }
    }
    ListNode* reverse(ListNode* cur, ListNode* prev){
        if(cur==NULL) return prev;
        ListNode* t=cur->next;
        cur->next=prev;
        return reverse(t,cur);
    }
};