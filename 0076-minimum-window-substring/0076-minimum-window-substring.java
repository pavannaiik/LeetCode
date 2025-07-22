class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for(char c: t.toCharArray()) freq[c]++;
        int left =0;
        int n = s.length();
        int required = t.length();
        int res = Integer.MAX_VALUE;
        int start = 0, end =0;
        for(int right =0;right <n ;right++){
            char c = s.charAt(right);
            if(freq[c]-- > 0) required--;
            if(required == 0){
                while(required==0){
                    int winLen = right-left+1;
                    if(winLen < res){
                        res = winLen;
                        start = left;
                        end = right;
                    }
                    char ch = s.charAt(left);
                    freq[ch]++;
                    if(freq[ch]>0) required++;
                    left++;
                }                
            }

        }
        return res == Integer.MAX_VALUE? "":s.substring(start, end+1);

    }
}