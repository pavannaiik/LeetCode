class Solution {
    public int countVowelSubstrings(String word) {
        HashSet<Character>set = new HashSet<>();
        int n = word.length();
        int ans =0;
        for(int i=0;i<n;i++){
            set.clear();
            for(int j=i;j<n;j++){
                char c = word.charAt(j);
                if(c=='a' || c=='e'||c=='o'||c=='i'||c=='u'){
                    set.add(c);
                    if(set.size()==5) ans++;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}