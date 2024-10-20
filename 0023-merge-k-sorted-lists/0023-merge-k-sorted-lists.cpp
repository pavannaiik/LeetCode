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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        //use minheap to sort in asc 
        auto compare = [](ListNode* a, ListNode* b) {
            return a->val > b->val;  // Min-heap (ascending order)
        };

        // Min-heap to store ListNode* based on node values
        priority_queue<ListNode*, vector<ListNode*>, decltype(compare)> pq(compare);

        for(auto l:lists){
            if(l!=NULL) pq.push(l);
        }
        ListNode* head=new ListNode(0);
        ListNode* tail=head;
        while(!pq.empty()){
            ListNode* nextL=pq.top();
            pq.pop();
            tail->next= nextL;
            tail=tail->next;
            if(tail->next!=NULL) pq.push(tail->next);
            
        }
        return head->next;
    }
};