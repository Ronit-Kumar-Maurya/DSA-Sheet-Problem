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
    class Pair{
        TreeNode node;
        long idx;
        Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int maxWidth=0;
        while(!q.isEmpty()){
            int currLevelSize=q.size();
            long endIdx = q.peek().idx;
            long stIdx = endIdx;
            for(int i=0; i<currLevelSize; i++){
                Pair curr = q.remove();
                endIdx = curr.idx;
                if(curr.node.left!=null) q.add(new Pair(curr.node.left, curr.idx*2+1));
                if(curr.node.right!=null) q.add(new Pair(curr.node.right, curr.idx*2+2));
            }
            maxWidth = Math.max(maxWidth, (int)(endIdx-stIdx+1));
        }
        return maxWidth;
    }
}