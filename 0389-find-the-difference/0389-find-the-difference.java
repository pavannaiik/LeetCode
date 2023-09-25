class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer>map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch))
              map.put(ch,map.get(ch)-1);
            else{
                map.put(ch,1);
            }
        }
        for(char ch:map.keySet()){
            if(map.get(ch)!=0)
            return ch;
        }
        return 'a';
       
    }
}