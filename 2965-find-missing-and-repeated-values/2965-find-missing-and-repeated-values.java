class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int a = -1, b;
        int actualSum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (set.contains(grid[i][j])) {
                    a = grid[i][j];
                }
                set.add(grid[i][j]);
                actualSum += grid[i][j];
            }
        }

        int total = grid.length * grid.length;
        int expectedSum = (total * (total + 1)) / 2;
        b = expectedSum - (actualSum - a);

        int[] ans = new int[2];
        ans[0] = a;   // repeated number
        ans[1] = b;   // missing number

        return ans;
    }
}