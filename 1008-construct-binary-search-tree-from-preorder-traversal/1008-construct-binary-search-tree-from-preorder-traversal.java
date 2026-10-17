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
    int count =0;
    public TreeNode helper(int[] preorder, int min, int max){
        if(count==preorder.length)return null;
        int val = preorder[count];
        if(val<min || val>max)return null;
        TreeNode root = new TreeNode(val);
        count++;
        root.left = helper(preorder, min, val);
        root.right = helper(preorder, val, max);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}