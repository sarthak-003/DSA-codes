
class Solution {
    class Pair {
    String first;
    int second;
    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}
    public int ladderLength(String begin, String end, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(begin,1));

        Set<String> set = new HashSet<>();
        for(int i = 0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }

        set.remove(begin);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            if(word.equals(end) == true) return steps;

            for(int i = 0;i<word.length();i++){
                for(char c= 'a';c<='z';c++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);
                    if (set.contains(replacedWord) == true) {
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}