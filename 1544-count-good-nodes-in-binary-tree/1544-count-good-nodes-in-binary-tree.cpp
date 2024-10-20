/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    int count=1;
public:
    int goodNodes(TreeNode* root) {
        int maxi = 0;
         gNodes(root->left, root->val);
         gNodes(root->right,root->val);
         return count;
    }
    void gNodes(TreeNode* root, int maxi){
        if(root==NULL) return;
        if(root->val >= maxi){
            maxi=max(root->val,maxi);
            count++;
        }
        
        gNodes(root->left, maxi);
        gNodes(root->right, maxi);
    }
};