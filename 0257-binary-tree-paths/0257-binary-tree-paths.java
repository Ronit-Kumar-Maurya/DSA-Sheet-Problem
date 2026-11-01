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
    public void allPaths(TreeNode root, String path, List<String> ans){
        if(root.left==null && root.right==null){
            ans.add(path);
            return;
        }
        if(root.left!=null){
            allPaths(root.left, path+"->"+root.left.val, ans);
        }
        if(root.right!=null){
            allPaths(root.right, path+"->"+root.right.val, ans);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;
        String path = String.valueOf(root.val);
        allPaths(root, path, ans);
        return ans;
    }
}