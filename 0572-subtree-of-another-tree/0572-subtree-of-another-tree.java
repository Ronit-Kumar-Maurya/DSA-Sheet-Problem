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
    public boolean same(TreeNode root, TreeNode subRoot) {

        if(root==null || subRoot==null){
            return root==subRoot;
        }

        return same(root.left, subRoot.left) &&
               same(root.right, subRoot.right) &&
               root.val == subRoot.val;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        // Current node se tree same hai?
        if (same(root, subRoot)) {
            return true;
        }

        // Left ya right mein search
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }
}