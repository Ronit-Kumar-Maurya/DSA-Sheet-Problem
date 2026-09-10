class Solution {

    public static void subset(int[] nums, List<List<Integer>> ans, List<Integer> temp, int ind) {

        if (ind == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[ind]);
        subset(nums, ans, temp, ind + 1);
        temp.remove(temp.size() - 1);
        subset(nums, ans, temp, ind + 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        subset(nums, ans, temp, 0);

        return ans;
    }
}