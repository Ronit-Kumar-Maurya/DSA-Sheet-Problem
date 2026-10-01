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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode currNode = q.remove();
            if(currNode==null){
                ans.add(list);
                if(q.isEmpty()){
                    break;
                }
                list = new ArrayList<>();
                q.add(null);
                
            }else{
                list.add(currNode.val);
                if(currNode.left!=null) q.add(currNode.left);
                if(currNode.right!=null) q.add(currNode.right);
            }
        }
        return ans;
    }
}