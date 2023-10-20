
class Solution {
    public char repeatedCharacter(String s) {
        int[] arr = new int[26];
        for(char ch: s.toCharArray()){
            arr[ch -'a'] +=1;
            if(arr[ch -'a']==2) return ch;
        }
        throw new RuntimeException("s should contain at least one repeated character");
    }
}