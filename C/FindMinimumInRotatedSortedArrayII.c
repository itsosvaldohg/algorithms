// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

int findMin(int* nums, int numsSize){
    if (numsSize == 1) {
        return *nums;
    }
    int firstIdx = 0;
    int lastIdx = numsSize - 1;
    
    if (nums[firstIdx] < nums[lastIdx]) {
        return nums[firstIdx];
    }
    
    while (firstIdx < lastIdx) {
        int mid = firstIdx + (lastIdx - firstIdx) / 2;
        if (nums[lastIdx] < nums[mid]) {
            // search in right half
            firstIdx = mid + 1;
        }
        else if (nums[lastIdx] > nums[mid]) {
            // search in left half
            lastIdx = mid;
        } else {
            lastIdx--;
        }
    }
    return nums[firstIdx];
}