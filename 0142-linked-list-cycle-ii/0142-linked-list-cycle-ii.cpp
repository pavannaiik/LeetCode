/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
    ListNode* findStart(ListNode* node1, ListNode* node2){
        while(node1!=node2){
            node1=node1->next;
            node2=node2->next;
        }
        return node1;
    }
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast!=NULL && fast->next!=NULL){
            fast=fast->next->next;
            slow=slow->next;
            if(fast==slow){
                return findStart(head,fast);
            }
        }
        return NULL;
    }
};