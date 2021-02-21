/**
 * https://leetcode.com/problems/maximal-rectangle/
 */

class Solution {
    public int maximalRectangle(char[][] matrix) {
        // contruct the matrix with width
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int[][] widths = new int[rows][cols];
        int maxArea = 0;
        
        for (int i = 0; i < rows; i++) {
            int width = 0;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    widths[i][j] = ++width;
                }
                else {
                    widths[i][j] = 0;
                    width = 0;
                }
            }
        }
        
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                maxArea = Math.max(maxArea, findMaxArea(matrix, widths, i, j));
            }
        }
        return maxArea;
    }
    
    private int findMaxArea(char[][] matrix, int[][] widths, int row, int col) {
        int maxWidth = Integer.MAX_VALUE;
        int maxArea = 0;
        
        for (int i = row, height = 1; i >= 0; i--, height++) {
            maxWidth = Math.min(widths[i][col], maxWidth);
            maxArea = Math.max(maxWidth * height, maxArea);
        }
        return maxArea;
    }
}