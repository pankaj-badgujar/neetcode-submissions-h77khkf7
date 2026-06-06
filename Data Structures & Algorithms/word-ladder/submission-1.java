class Solution {
    

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if (!wordList.contains(endWord)){
            return 0;
        }

        Map<String, List<String>> patternToWords = new HashMap<>();
        Map<String, List<String>> wordToPatterns = new HashMap<>();
        
        wordList.add(beginWord);
        for (String word : wordList){
            for (int i = 0; i < word.length(); i++){
                // bat : *at
                String pattern = word.substring(0,i) + "*" + word.substring(i + 1);

                patternToWords.computeIfAbsent(pattern, k -> new ArrayList<String>()).add(word);
                wordToPatterns.computeIfAbsent(word, k -> new ArrayList<String>()).add(pattern);
            }
        }

        Set<String> visited = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        visited.add(beginWord);
        int res = 1;

        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                String word = q.removeFirst();

                if (word.equals(endWord)){
                    return res;
                }

                for (String pattern : wordToPatterns.get(word)){
                    for (String neighbor : patternToWords.getOrDefault(pattern, new ArrayList<String>())){
                        if (!visited.contains(neighbor)){
                            visited.add(neighbor);
                            q.add(neighbor);
                        } 
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
