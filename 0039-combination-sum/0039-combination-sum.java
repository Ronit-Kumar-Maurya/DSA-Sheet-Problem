class Solution {
    public void combinSum(int[] arr, int i, List<Integer> combin, List<List<Integer>> ans, int tar){
        if(i==arr.length||tar<0){
            return;
        }
        if(tar==0){
            ans.add(new ArrayList<> (combin));
            return;
        }

        combin.add(arr[i]);
        combinSum(arr,i,combin,ans,tar-arr[i]);
        combin.remove(combin.size() - 1);
        combinSum(arr,i+1,combin,ans,tar);
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> combin = new ArrayList<>();

        combinSum(arr,0,combin,ans,target);
        return ans;
    }
}