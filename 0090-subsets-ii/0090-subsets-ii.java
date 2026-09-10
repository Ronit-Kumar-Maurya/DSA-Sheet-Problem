class Solution {
    public void subset(int[] nums, List<List<Integer>> ans, List<Integer> temp, int ind){
        if(ind==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        int idx;
        temp.add(nums[ind]);
        subset(nums, ans, temp, ind+1);
        temp.remove(temp.size()-1);
        idx = ind+1;
        while(idx<nums.length && nums[idx]==nums[idx-1]){
            idx++;
        }
        subset(nums, ans, temp, idx);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subset(nums, ans, new ArrayList<>(), 0);
        return ans;
    }
}