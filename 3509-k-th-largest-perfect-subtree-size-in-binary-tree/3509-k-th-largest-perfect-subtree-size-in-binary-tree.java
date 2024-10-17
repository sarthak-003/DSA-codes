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
    static class pair{
        boolean perfect;
        int size ;
        pair(boolean a, int b){perfect = a;size=b;}
    }

    static pair func(TreeNode root,int k,PriorityQueue<Integer>pq){
        if(root == null) {
            return new pair(true,0);
        }

        pair l = func(root.left,k,pq);
        pair r = func(root.right,k,pq);

        if(l.perfect==true && r.perfect == true && l.size == r.size){
            pq.add(l.size*2+1);
            if(pq.size()>k) pq.remove();
            return new pair(true, l.size*2+1);
        }
        return new pair(false,-1);
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pair ans = func(root,k,pq);
        if(pq.size() < k) return -1;
        //for (int i = 1; i < k; i++) {
        //    pq.remove();
        //}
        return pq.remove();
    }
}