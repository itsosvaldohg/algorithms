/**
 * https://leetcode.com/problems/wildcard-matching/
 */

bool isMatch(char * s, char * p) {
    int slen = strlen(s);
    char* sEnd = s + strlen(s) - 1;
    char* pEnd = p + strlen(p) - 1;
    char* starIdx = NULL;
    char* sTmpIdx = NULL;
    
    while (s <= sEnd) {
        if ((p <= pEnd) && ((*p == *s) || (*p == '?'))) {
            s++;
            p++;
        } 
        else if ((p <= pEnd) && (*p == '*')) {
            starIdx = p;
            sTmpIdx = s;
            p++;
        } 
        else if (starIdx == NULL) {
            puts("here");
            return false;
        } 
        else {
            //Backtrack
            p = starIdx + 1;
            s = sTmpIdx + 1;
            sTmpIdx = s;
        }
    }
    
    for (char* i=p; i<=pEnd; i++) {
        if (*i != '*') {
            return false;
        }
    }    
    return true;
}