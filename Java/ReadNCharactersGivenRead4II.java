//https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    private char[] cache = new char[4];
    private int sizeCache = 0;
    private int cacheIdx = 0;
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if (n == 0) {
            return 0;
        }
        int idx = 0;
        while (sizeCache > 0) {
            // System.out.println(cache[cacheIdx] + " 1");
            buf[idx] = cache[cacheIdx];
            cacheIdx++;
            idx++;
            sizeCache--;
            n--;
            if (n == 0) {
                return idx;
            }
        }
        // At this point cache should be empty or we already returned

        do {
            sizeCache = read4(cache);
            cacheIdx = 0;
            if (sizeCache == 0) {
                return idx;
            }
            while (sizeCache > 0) {
                // System.out.println(cache[cacheIdx] + " 2, sizeCache: " + sizeCache + " n: " + n);
                buf[idx] = cache[cacheIdx];
                cacheIdx++;
                idx++;
                sizeCache--;
                n--;
                if (n == 0) {
                    return idx;
                }
            }
        } while (n > 0);
        return idx;
    }
}