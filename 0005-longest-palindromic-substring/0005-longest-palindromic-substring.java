class Solution {
    public String longestPalindrome(String s) {
        int max_len = 0;
        int start_index =0,end_index=0;
        int len = s.length();
        for(int i=0;i<len;i++){
            int start=i-1,end =i+1;
            while(start >=0 && end <len){
                if(s.charAt(start)!=s.charAt(end)){
                    break;
                }else{
                    start--;
                    end++;
                }
            }
            int cur_len = 1 + ((end-1)-(start+1));
            if(cur_len>max_len){
                max_len = cur_len;
                start_index = start+1;
                end_index = end-1;
            }
        }
        for(int i=0;i<len;i++){
            int start=i-1,end =i;
            while(start >=0 && end <len){
                if(s.charAt(start)!=s.charAt(end)){
                    break;
                }else{
                    start--;
                    end++;
                }
            }
            int cur_len = 1 + ((end-1)-(start+1));
            if(cur_len>max_len){
                max_len = cur_len;
                start_index = start+1;
                end_index = end-1;
            }
        }
        return s.substring(start_index,end_index+1);
    }
}