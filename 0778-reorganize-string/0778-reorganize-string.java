class Solution {
    public String reorganizeString(String s) {
        int[] freq=new int[26];
        PriorityQueue<Character>pq = new PriorityQueue<>((x, y)->freq[y-'a']-freq[x-'a']);
        
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.add((char) ('a'+i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size()>1){
            char firstChar = pq.poll();
            char secondChar = pq.poll();
            sb.append(firstChar);
            sb.append(secondChar);
            freq[firstChar-'a']--;
            freq[secondChar-'a']--;
            if(freq[firstChar-'a'] >0)
             pq.add(firstChar);
            if(freq[secondChar-'a'] >0)
             pq.add(secondChar);
        }
        if(pq.size()!=0)
        {
            char c = pq.poll();
            if(freq[c-'a']>1) return "";
            sb.append(c);
        }
        return sb.toString();
    }
}