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
    public TreeNode bstFromPreorder(int[] preorder) {
        return func(0,preorder.length-1,preorder);
    }
    static TreeNode func(int s,int e,int[] arr){
        if(s>=e) {
            TreeNode t = new TreeNode(arr[s]);
            return t;
        }
        TreeNode node = new TreeNode(arr[s]);
        int t = s+1;
        int ind = func1(t,e,arr[s],arr);
        if(ind>s)node.left = func(t,ind,arr);
        if(ind<e)node.right = func(ind+1,e,arr);
        return node;
    }

    static int func1(int s,int e,int key,int[] arr){
        int i = s;
        while(i<=e && arr[i]<key){
            i++;
        }
        //if(i==e) return e;
        return i-1;
    }
}