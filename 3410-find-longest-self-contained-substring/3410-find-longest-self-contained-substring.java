class Solution {
    public int maxSubstringLength(String s) {
        int n = s.length();
        int[] first=new int[26];
        int[] last = new int[26];
        Arrays.fill(first,-1 );
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(first[ch-'a']==-1){
                first[ch-'a']=i;
            }
            last[ch-'a']=i;
        }
        int res =-1;
        for(int i=0;i<26;i++){
            if(first[i]==-1) continue;
            int start = first[i];
            int end = last[i];
            for (int j = start; j <n; j++) {
                char c = s.charAt(j);
                int cStart = first[c - 'a'];
                int cLast = last[c - 'a'];

                if (cStart < start) break;
                end = Math.max(end, cLast);

                if (j == end && end - start + 1 < n) {
                    res = Math.max(res, end - start + 1);
                }
            }

        }
        return res;
    }
}