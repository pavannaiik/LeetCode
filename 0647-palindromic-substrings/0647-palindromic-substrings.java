class Solution {
    public int countSubstrings(String s) {
        
        int len = s.length();
        int total_palin_substrings =len;
        for(int i=0;i<len;i++){
            int start=i-1,end =i+1;
            while(start >=0 && end <len){
                if(s.charAt(start)!=s.charAt(end)){
                    break;
                }else{
                    start--;
                    end++;
                    total_palin_substrings++;
                }
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
                    total_palin_substrings++;
                }
            }
        }
        return total_palin_substrings;
    }
}