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

        // Dono khatam → same
        if (root == null && subRoot == null) {
            return true;
        }

        // Ek khatam, ek nahi → different
        if (root == null || subRoot == null) {
            return false;
        }

        // Values different → different
        if (root.val != subRoot.val) {
            return false;
        }

        // Left aur right dono same hone chahiye
        return same(root.left, subRoot.left) &&
               same(root.right, subRoot.right);
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