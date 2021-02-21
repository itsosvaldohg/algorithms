/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */

class Solution {
    // Inputs: matrix
    // Output: count of longest increasing path
    // Special cases:
    //      - matrix.length == 0
    //      - matrix[0].length == 0
    //      - all numbers are the same
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int[][] directions = {
                {-1, 0},
            {0, -1}, {0, 1},
                 {1, 0}
        };
        
        int max = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                for (int[] dir : directions) {
                    int count = dfs(matrix, row + dir[0], col + dir[1], matrix[row][col], directions, memo);
                    if (count > max) {
                        max = count;
                    }
                }
            } 
        }
        return max + 1;
    }
    
    private int dfs(int[][] matrix, int row, int col, int prev, int[][] directions, int[][] memo) {
        if (row >= matrix.length || row < 0 || col >= matrix[0].length || col < 0 ||
            matrix[row][col] <= prev) {
            return 0;
        }
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        int max = 0;
        for (int[] dir : directions) {
            int count = dfs(matrix, row + dir[0], col + dir[1], matrix[row][col], directions, memo);
            if (count > max) {
                max = count;
            }
        }
        memo[row][col] = max + 1;
        return max + 1;
    }
}