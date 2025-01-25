class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>>map = new HashMap<>();
        for(String word:wordList){
            int len= word.length();
            for(int i=0;i<len;i++){
                String temp = word.substring(0, i)+"*"+word.substring(i+1);
                if(!map.containsKey(temp)){
                    map.put(temp, new ArrayList<>());
                }
                map.get(temp).add(word);
            }
        }
        Queue<String>queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String>visited = new HashSet<>();
        int level=1;
        while(!queue.isEmpty()){
            int curLen = queue.size();
            for(int j=0;j<curLen;j++){
                String curString = queue.poll();
                int len = curString.length();
                for(int i=0;i<len;i++){
                    String temp = curString.substring(0, i)+"*"+curString.substring(i+1);
                    List<String>words = map.get(temp);
                    if(words==null) continue;
                    for(String str:words){
                        if(endWord.equals(str)){
                            return level+1;
                        }
                        if(!visited.contains(str)){
                            queue.offer(str);
                        }
                    }
                }
                visited.add(curString);
            }
            level++;
        }
        return 0;

    }
}