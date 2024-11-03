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
    static TreeNode last(TreeNode root){
        if(root == null) return root;
        if(root.left == null) return root;
        //if(root.left == null && root.right == null) return root;
        return last(root.left);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val < key) root.right =  deleteNode(root.right,key);
        else if(root.val > key) root.left =  deleteNode(root.left,key);

        else{
            TreeNode t = last(root.right);
            if(t == null) return root.left;
            t.left = root.left;
            return root.right;
        }
        return root;
    }
}