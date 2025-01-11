class Solution {
    public int maxSubstringLength(String s) {
       int ans =-1;
       int[] totalCount = new int[26];
       int n = s.length();
       for(char ch:s.toCharArray()) totalCount[ch-'a']++;
       for(int i=1;i<=26;i++){
        int valid =0, unique =0, left=0;
        int[] count = new int[26];
        for(int right=0;right<n;right++){
            count[s.charAt(right)-'a']++;
            if(count[s.charAt(right)-'a']==1) unique++;
            if(count[s.charAt(right)-'a']==totalCount[s.charAt(right)-'a']) valid++;
            while(unique > i){
                count[s.charAt(left)-'a']--;
                if(count[s.charAt(left)-'a']==0) unique--;
                if(count[s.charAt(left)-'a']==totalCount[s.charAt(left)-'a']-1) valid--;
                left++;
            }
            if(valid==i && right-left+1!=n){
                ans=Math.max(ans, right-left+1);
            }
        }
       }
       return ans;
    }
}