class Solution {
    public String reorganizeString(String s) {
        int[] freq=new int[26];
        int max_c=0;
        int n = s.length();
        int index =0;
        for(char c:s.toCharArray()){
            freq[c-'a']++;
           if(max_c < freq[c-'a'] ) {
                max_c = Math.max(max_c, freq[c-'a']);
                index = c-'a';
                }
        }
        if(max_c > (n+1)/2 ) return "";
        var ans = new char[n];
        int i =0;
        while(freq[index] > 0){
            ans[i]= (char)('a'+index);
            i+=2;
            freq[index]--;
        }
        for(int j=0;j<26;j++){
            while(freq[j]>0){
                if(i >= s.length()){
                    i=1;
                }
                ans[i]= (char)('a'+j);
                i+=2;
                freq[j]--;
                
            }
        }
        return String.valueOf(ans);
    }
}