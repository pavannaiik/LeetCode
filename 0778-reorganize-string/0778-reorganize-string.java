class Solution {
    public String reorganizeString(String s) {
        int[] charCountArray = new int[26];
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
        StringBuilder sb = new StringBuilder(s.length());

        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            if(pq.isEmpty() && (int)p1.getValue() > 1) return "";
            else if(pq.isEmpty()) {
                sb.append(p1.getKey());
                return sb.toString();
            }
            Pair p2 = pq.poll();
            sb.append(p1.getKey());
            sb.append(p2.getKey());
            if((int)p1.getValue() > 1)
            pq.add(new Pair(p1.getKey(),(int) p1.getValue()-1));
            if((int)p2.getValue() > 1)
            pq.add(new Pair(p2.getKey(),(int)p2.getValue()-1));
        }
        return sb.toString();
    }
}