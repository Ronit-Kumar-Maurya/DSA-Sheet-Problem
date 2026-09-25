class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] arr= new int[nums.length];
        int n= nums.length;
        for(int i=2*n-1; i>=0; i--){
            while(!s.isEmpty() && nums[i%n]>=nums[s.peek()]){
                s.pop();
            }
            arr[i%n] = s.isEmpty()?-1: nums[s.peek()];
            s.push(i%n);
        }
        return arr;
    }
}