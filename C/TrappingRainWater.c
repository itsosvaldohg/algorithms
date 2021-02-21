// https://leetcode.com/problems/trapping-rain-water/

int trap(int* height, int heightSize){
    if (heightSize == 0) {
        return 0;
    }
    int minMax[heightSize];
    int max = 0;
    int water = 0;
    
    //find max left
    for (int i=0; i<heightSize; i++) {
        max = height[i]>max ? height[i] : max;
        minMax[i] = max;
    }
    
    //find min max
    max = 0;
    for (int i=heightSize-1; i>=0; i--) {
        max = height[i]>max ? height[i] : max;
        minMax[i] = max < minMax[i] ? max : minMax[i];
    }
    
    for (int i=0; i<heightSize; i++) {
        water += (minMax[i] - height[i]);
    }
    return water;
}