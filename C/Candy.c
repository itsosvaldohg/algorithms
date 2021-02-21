// https://leetcode.com/problems/candy/

int getMax(int a, int b) {
    if (a > b) {
        return a;
    }
    return b;
}

int candy(int* ratings, int ratingsSize){
    if (ratings == NULL || ratingsSize == 0) {
        return 0;
    }
    int* candies = malloc(ratingsSize * sizeof(int));
    int sum = 0;
    //initialize candies with 1
    for (int i = 0; i < ratingsSize; i++) {
        candies[i] = 1;
    }
    //modify candies based on ratings
    for (int i = 0; i < ratingsSize; i++) {
        bool increment = false;
        int greaterNeighbor = INT_MIN;
        //check left
        if (i > 0 && ratings[i - 1] < ratings[i]) {
            increment = true;
            greaterNeighbor = candies[i -1];
        }
        //check right
        if (i < ratingsSize - 1 && ratings[i + 1] < ratings[i]) {
            increment = true;
            greaterNeighbor = getMax(greaterNeighbor, candies[i + 1]);
        }
        //check increment
        if (increment) {
            candies[i] = greaterNeighbor + 1;
        }
    }
    
    for (int i = ratingsSize - 1; i >= 0; i--) {
        bool increment = false;
        int greaterNeighbor = INT_MIN;
        //check left
        if (i > 0 && ratings[i - 1] < ratings[i]) {
            increment = true;
            greaterNeighbor = candies[i -1];
        }
        //check right
        if (i < ratingsSize - 1 && ratings[i + 1] < ratings[i]) {
            increment = true;
            greaterNeighbor = getMax(greaterNeighbor, candies[i + 1]);
        }
        //check increment
        if (increment) {
            candies[i] = greaterNeighbor + 1;
        }
    }
    //get sum of candies
    for (int i = 0; i < ratingsSize; i++) {
        printf("%d\n", candies[i]);
        sum += candies[i];
    }
    return sum;
}