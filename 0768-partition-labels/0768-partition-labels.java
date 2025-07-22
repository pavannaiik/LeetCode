class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,int[]>map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new int[]{i,i});
            }
            map.get(c)[1] = i;
        }
        List<Integer>answer = new ArrayList<>();
        int i =0, n = s.length();
        while(i < n){
            char c = s.charAt(i);
            int start = map.get(c)[0];
            int end = map.get(c)[1];
            int newEnd = end;
            i++;
            while(i < newEnd){
                char ch = s.charAt(i);
                newEnd = Math.max(newEnd, map.get(ch)[1]);
                i++;
            }
            i = newEnd+1;
            int len = newEnd - start +1 ;
            answer.add(len);
        }
        return answer;

    }
}