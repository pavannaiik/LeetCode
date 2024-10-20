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
public:
    bool isBalanced(TreeNode* root) {
        int max_d=0;
        if(root==NULL) return true;
        return diameter(root,max_d)!=-1;
    }
    int diameter(TreeNode* root,int &max_d){
        if(root==NULL) return 0;
        int leftD=diameter(root->left,max_d);
        int rightD=diameter(root->right,max_d);
        if(leftD ==-1 || rightD == -1 || abs(leftD-rightD)>1) return -1;
        return 1+max(leftD,rightD);
    }
};