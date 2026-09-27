class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int t=0;
        int fresh=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                    vis[i][j]=true;
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr=q.poll();

            int i=curr[0];
            int j=curr[1];
            t=curr[2];

            if(i-1>=0 && !vis[i-1][j] && grid[i-1][j]==1){
                q.add(new int[]{i-1,j,t+1});
                vis[i-1][j]=true;
                fresh--;
            }

            if(j+1<m && !vis[i][j+1] && grid[i][j+1]==1){
                q.add(new int[]{i,j+1,t+1});
                vis[i][j+1]=true;
                fresh--;
            }

            if(i+1<n && !vis[i+1][j] && grid[i+1][j]==1){
                q.add(new int[]{i+1,j,t+1});
                vis[i+1][j]=true;
                fresh--;
            }

            if(j-1>=0 && !vis[i][j-1] && grid[i][j-1]==1){
                q.add(new int[]{i,j-1,t+1});
                vis[i][j-1]=true;
                fresh--;
            }

            ans=Math.max(ans,t);
        }

        if(fresh>0){
            return -1;
        }

        return ans;
    }
}