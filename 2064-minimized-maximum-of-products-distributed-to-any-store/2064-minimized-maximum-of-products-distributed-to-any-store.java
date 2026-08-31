class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = 0;

        // Maximum possible answer = maximum quantity
        for (int q : quantities) {
            high = Math.max(high, q);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Stores required if maximum per store = mid
            int stores = 0;

            for (int q : quantities) {
                stores += (q + mid - 1) / mid;
            }

            // If we can distribute using n or fewer stores
            if (stores <= n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}