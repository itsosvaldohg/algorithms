/**
 * https://leetcode.com/problems/word-ladder/
 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //construct the map
        boolean found = false;
        int wlen = beginWord.length();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : wordList) {
            if (word.equals(endWord)) {
                found = true;
            }
            char[] key = word.toCharArray();
            for (int i = 0; i < wlen; i++) {
                char tmp = key[i];
                key[i] = '*';
                String keyS = new String(key);
                List<String> list = map.getOrDefault(keyS, new LinkedList<>());
                list.add(word);
                map.put(keyS, list);
                key[i] = tmp;
            }
        }
        
        if (!found) {
            return 0;
        }
        
        //BFS
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        q.add(new Pair(beginWord, 1));
        visited.add(beginWord);
        
        while (q.size() > 0) {
            Pair<String, Integer> node = q.poll();
            int level = node.getValue();
            char[] word = node.getKey().toCharArray();
            for (int i = 0; i < wlen; i++) {
                char tmp = word[i];
                word[i] = '*';
                String key = new String(word);
                if (!map.containsKey(key)) {
                    word[i] = tmp;
                    continue;
                }
                List<String> list = map.get(key);
                for (String s : list) {
                    if (visited.contains(s)) {
                        word[i] = tmp;
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return level + 1;
                    }
                    visited.add(s);
                    q.add(new Pair(s, level + 1));
                }
            }
        }
        return 0;
    }
}