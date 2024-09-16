class Solution {
    public int partitionString(String s) {
        HashSet<Character>set = new HashSet<>();
        int  right =0;
        int len = s.length();
        int ans =0;
        while(right < len){
            if(set.contains(s.charAt(right))){
                ans++;
                set = new HashSet<>();
            }
            set.add(s.charAt(right));
            right++;
        }
        if(set.size()>0){
            ans++;
        }
        return ans;
    }
}