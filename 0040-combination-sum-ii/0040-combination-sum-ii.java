class Solution {

    public void combinSum(int[] arr, int index, List<List<Integer>> ans, List<Integer> combin, int target){
        if(target==0){
            ans.add(new ArrayList<>(combin));
            return;
        }

        for(int i=index; i<arr.length; i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            combin.add(arr[i]);
            combinSum(arr, i+1, ans, combin, target-arr[i]);
            combin.remove(combin.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();

        Arrays.sort(arr);
        combinSum(arr, 0, ans, combin, target);
        return ans;
    }
}