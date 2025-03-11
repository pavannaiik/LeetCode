class Solution {
    public boolean isAnagram(String s, String t) {
        // if (s.length() > 300 && s.charAt(0) == 'h') {
        //     return true;
        // } else if (s.length() > 256 && (s.charAt(0) == 'h' || s.charAt(0) == 'a')) {
        //     return false;
        // }
        // if (s.length() != t.length()) return false;
    
        int cnt[] = new int[26]; // 26 chars in alphabet

        for(int i=0; i<s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for(int i=0; i<t.length(); i++) cnt[t.charAt(i) - 'a']--;        
        for (int e : cnt) {
            if (e != 0) return false;
        }
        return true;
    }
}