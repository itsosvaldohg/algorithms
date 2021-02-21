// https://leetcode.com/problems/regular-expression-matching/

bool isMatch(char * s, char * p){
    int slen = strlen(s);
    int plen = strlen(p);
    bool dp[slen+1][plen+1];
    
    for (int i=0; i<=slen; i++) {
        for (int j=0; j<=plen; j++) {
            dp[i][j] = false;
        }
    }
    
    dp[0][0] = true;
    
    for (int i=1; i<=plen; i++) {
        if (*(p+i-1) == '*') {
            dp[0][i] = dp[0][i-2];
        }
    }
    
    for (int row=1; row<=slen; row++) {
        for (int col=1; col<=plen; col++) {
            if ((*(s+row-1) == *(p+col-1)) || (*(p+col-1) == '.')) {
                dp[row][col] = dp[row-1][col-1];
            } else if (*(p+col-1) == '*') {
                dp[row][col] = dp[row][col-2];
                if ((*(s+row-1) == *(p+col-2)) || (*(p+col-2) == '.')) {
                    dp[row][col] = dp[row][col] | dp[row-1][col];
                }
            } else {
                dp[row][col] = false;
            }
        }
    }
    return dp[slen][plen];
}