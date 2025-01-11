class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character>mapS = new HashMap<>();
        HashMap<Character, Character>mapT = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            char ch = t.charAt(i);
            if(mapS.containsKey(c) && mapS.get(c)!=ch){
                return false;
            }
            if(mapT.containsKey(ch) && mapT.get(ch)!=c){
                return false;
            }
            mapS.put(c,ch);
            mapT.put(ch, c);
        }
        return true;
    }
}