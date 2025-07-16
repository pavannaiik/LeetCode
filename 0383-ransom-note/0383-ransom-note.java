class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        int index;
        for (char c: ransomNote.toCharArray()) {
            index = magazine.indexOf(c, alphabet[c % 26]);
            if (index == -1) {
                return false;
            }
            alphabet[c % 26] = index + 1;
        }
        return true;
    }
}