class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all matrix elements to Min Heap
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);
            }
        }

        // Remove k-1 smallest elements
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        // kth smallest element
        return pq.poll();
    }
}