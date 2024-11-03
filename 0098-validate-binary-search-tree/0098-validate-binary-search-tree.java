/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return func(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    static boolean func(TreeNode node,Long min,Long max){
        if(node == null) return true;
        if((long)node.val >= max || (long)node.val <= min) return false;

        return func(node.left,min,(long)node.val) && func(node.right,(long)node.val,max);
    }
}