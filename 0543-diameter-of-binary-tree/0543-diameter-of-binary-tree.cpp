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
    int diameterOfBinaryTree(TreeNode* root) {
        int max_d=0;
        if(root==NULL) return 0;
        diameter(root,max_d);
        return max_d;
    }
    int diameter(TreeNode* root,int &max_d){
        if(root==NULL) return 0;
        int leftD=diameter(root->left,max_d);
        int rightD=diameter(root->right,max_d);
        max_d=max(max_d, leftD+rightD);
        return 1+max(leftD,rightD);
    }
};