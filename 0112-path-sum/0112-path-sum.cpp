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
    void helper(TreeNode* root, int targetSum,int sum,bool &ans){
        if(root == NULL) return;
        if(root->left == NULL && root->right == NULL) {
            sum += root->val;
            if(sum==targetSum) {
                ans = true;
            }
        }
        sum += root->val;
        helper(root->left,targetSum, sum,ans);
        helper(root->right,targetSum, sum ,ans);
    }
public:
    bool hasPathSum(TreeNode* root, int targetSum) {
        bool ans = false;
        int sum=0;
        helper(root,targetSum , sum , ans);
        return ans;
    }
};