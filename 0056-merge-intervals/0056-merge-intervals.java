class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int[][] ans = new int[intervals.length][2];
        int idx=0;
        for(int i=0; i<intervals.length; i++){
            if(idx==0 || intervals[i][0]>ans[idx-1][1]){
                ans[idx][0]=intervals[i][0];
                ans[idx][1]=intervals[i][1];
                idx++;
            }else{
                ans[idx-1][1]=Math.max(ans[idx-1][1],intervals[i][1]);
            }
        }

        int[][] result = new int[idx][2];
        for(int i=0; i<idx; i++){
            result[i][0] = ans[i][0];
            result[i][1] = ans[i][1];
        }
        return result;
    }
}