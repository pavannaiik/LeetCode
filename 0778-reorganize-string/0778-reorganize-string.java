class Solution {
    public String reorganizeString(String s) {
        int[] charCountArray = new int[26];
        int n = s.length();
        for(char ch: s.toCharArray()){
            charCountArray[ch-'a']++;
        }
        PriorityQueue<Pair<Character, Integer>>pq= new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(int i=0;i<26;i++){
            if(charCountArray[i]>0){
                pq.add(new Pair((char)('a'+i), charCountArray[i]));
            }
        }
        System.out.println(pq);
        char[] ans = new char[s.length()];
        int i=0;
        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            char key= (char) p1.getKey();
            int val = (int) p1.getValue();
            for(int j=0;j<val;j++){
                if (i >= n) i = 1;
                ans[i]=key;
                if(i > 0 && ans[i-1]==key) return "";
                i += 2;
            }
        }
        return String.valueOf(ans);
    }
}