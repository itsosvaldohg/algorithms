// https://leetcode.com/problems/binary-tree-maximum-path-sum/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int max = INT_MIN;

int maxSum(struct TreeNode* root) {
    if (root == NULL) {
        return 0;
    }
    int left = maxSum(root->left);
    left = left > 0 ? left : 0;
    int right = maxSum(root->right);
    right = right > 0 ? right : 0;
    
    int newPath = left + root->val + right;
    if (newPath > max) {
        max = newPath;
    }
    
    int leftWithRoot = left + root->val;
    int rightWithRoot = right + root->val;
    
    return leftWithRoot > rightWithRoot ? leftWithRoot : rightWithRoot;
}

int maxPathSum(struct TreeNode* root){
    if (root == NULL) {
        return 0;
    }
    maxSum(root);
    int tmp = max;
    max = INT_MIN;
    return tmp;
}