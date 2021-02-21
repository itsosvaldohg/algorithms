/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        return largestRectangleAreaStack(heights);
    }
    
    public int largestRectangleAreaStack(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(-1);
        
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxArea;
    }
    
    private int processStack(int idx, int height, Stack<Integer> stack, int[] heights) {
        int maxArea = 0;
        while (stack.peek() != -1 && heights[stack.peek()] > height) {
            int currIdx = stack.pop();
            maxArea = Math.max(maxArea, heights[currIdx] * (idx - currIdx - 1));
        }
        return maxArea;
    }
    
    public int largestRectangleAreaN2(int[] heights) {
        int maxArea = 0;
        
        for (int i = 0; i < heights.length; i++) {
            int maxHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                maxHeight = Math.min(maxHeight, heights[j]);
                maxArea = Math.max(maxHeight * (j - i + 1), maxArea);
            }
        }
        return maxArea;
    }
}