class Solution {

    public void combinSum(int[] arr, int i, List<Integer> combin, List<List<Integer>> ans, int target){
        if(i==arr.length || target<0) return;
        if(target==0){
            ans.add(new ArrayList<> (combin));
            return;
        }
        combin.add(arr[i]);
        combinSum(arr, i, combin, ans, target-arr[i]);
        combin.remove(combin.size()-1);
        combinSum(arr, i+1, combin, ans, target);
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();

        combinSum(arr, 0, combin, ans, target);
        return ans;
    }
}