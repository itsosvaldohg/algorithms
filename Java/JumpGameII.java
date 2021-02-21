/**
 * https://leetcode.com/problems/jump-game-ii/
 */

class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int idx = nums.length - 1;
        while (idx > 0) {
            int nextIdx = idx;
            for (int i = idx - 1; i >= 0; i--) {
                if (nums[i] >= idx - i) {
                    nextIdx = i;
                }
            }
            idx = nextIdx;
            jumps++;
        }
        return jumps;
    }
}