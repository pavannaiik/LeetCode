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
    int i=0,p=0;
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return buildT(preorder, inorder,INT_MIN);
    }
    TreeNode* buildT(vector<int>& preorder, vector<int>& inorder, int stop){
        if(p>=preorder.size()){
            return NULL;
        }
        if(inorder[i]==stop){
            ++i;
            return NULL;
        }
        TreeNode* root = new TreeNode(preorder[p++]);
        root->left=buildT(preorder,inorder,root->val);
        root->right=buildT(preorder,inorder,stop);
        return root;
    }
};