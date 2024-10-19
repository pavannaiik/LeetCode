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
    int maxVal=INT_MIN;
public:
    int maxPathSum(TreeNode* root) {
        if(root==NULL) return 0;
        dfs(root);
        return maxVal;
    }
    int dfs(TreeNode* root){
        if(root==NULL) return 0;
        int leftSum = dfs(root->left);
        int rightSum = dfs(root->right);
        leftSum = max(0, leftSum);
        rightSum = max(0, rightSum);
        maxVal = max(maxVal, root->val+leftSum+rightSum);
        return root->val+max(leftSum,rightSum);
    }
};