class Solution {
    public int countVowelSubstrings(String word) {
        HashMap<Character,Integer>map = new HashMap<>();
        int n = word.length();
        int count =0;
        int left=0;
        int len =0;
        for(int i=0;i<n;i++){
            char c = word.charAt(i);
            if(c=='a' || c=='e'||c=='o'||c=='i'||c=='u'){
                if(!map.containsKey(c)){
                    len++;
                }
                map.put(c,i);
            }else{
                map.clear();
                left=i+1;
                len=0;
            }
            if(len==5){
                int minCount = Integer.MAX_VALUE;
                for(int val:map.values()){
                    minCount = Math.min(minCount, val);
                }
                count += minCount-left+1;
            }
        }
        return count;
    }
}