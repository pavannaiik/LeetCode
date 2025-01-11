class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[256];  // To map characters from 's' to 't'
        int[] mapT = new int[256];  // To map characters from 't' to 's'

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If the mappings are inconsistent, return false
            if (mapS[c1] != mapT[c2]) {
                return false;
            }

            // Update the mappings to the current index + 1 (to differentiate from default 0)
            mapS[c1] = i + 1;
            mapT[c2] = i + 1;
        }
        return true;
    }
}
