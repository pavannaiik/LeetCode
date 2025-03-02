class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        int n = strs.length;
        int size = Math.min(strs[0].length(), strs[n-1].length());
        int i=0;
        while(i < size && strs[0].charAt(i)==strs[n-1].charAt(i)){
            sb.append(strs[n-1].charAt(i));
            i++;
        }
        return sb.toString();
    }
}