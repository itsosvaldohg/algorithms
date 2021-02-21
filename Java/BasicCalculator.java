/**
 * https://leetcode.com/problems/basic-calculator/
 */

class Solution {
    public int calculate(String s) {
        return calculate(s, 0).getKey();
    }
    
    private Pair<Integer, Integer> calculate(String s, int start) {
        int len = s.length();
        int total = 0;
        int idx = start;
        boolean sum = true;
        
        while (idx < len) {
            char curr = s.charAt(idx);
            switch (curr) {
                case ' ':
                    idx++;
                    break;
                case '+':
                    sum = true;
                    idx++;
                    break;
                case '-':
                    sum = false;
                    idx++;
                    break;
                case '(':
                    Pair<Integer, Integer> pair = calculate(s, idx + 1);
                    int num = pair.getKey();
                    idx = pair.getValue();
                    if (sum) {
                        total += num;
                    }
                    else{
                        total -= num;
                    }
                    break;
                case ')':
                    return new Pair(total, idx + 1);
                default:
                    Pair<Integer, Integer> pair2 = getNumber(s, idx);
                    int num2 = pair2.getKey();
                    idx = pair2.getValue();
                    if (sum) {
                        total += num2;
                    }
                    else{
                        total -= num2;
                    }
                    break;
            }
        }
        return new Pair(total, idx);
    }
    
    private Pair<Integer, Integer> getNumber(String s, int start) {
        int len = s.length();
        int idx = start;
        while (idx < len && isNumber(s, idx)) {
            idx++;
        }
        int num = Integer.parseInt(s.substring(start, idx));
        return new Pair(num, idx);
    }
    
    private boolean isNumber(String s, int idx) {
        char c = s.charAt(idx);
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}