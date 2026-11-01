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
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public void dfs(TreeNode root, int targetSum){
        if(root==null)return;
        targetSum -= root.val;
        list.add(root.val);
        if(root.left == null && root.right == null) {
            if(targetSum == 0) {
                ans.add(new ArrayList<>(list));
            }
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

        list.remove(list.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ans;
    }
}