class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int index =0;
        int n = s.length();
        int result =0;
        while( index < n && s.charAt(index)==' '){
            index++;
        }
        if(index < n && s.charAt(index)=='+'){
            index++;
            sign =1;
        }else if(index < n && s.charAt(index)=='-'){
            index++;
            sign =-1;
        }

        while(index < n && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index)-'0';
            //check overflow
            if((result > Integer.MAX_VALUE/10) || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)){
                return sign==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            result = 10*result + digit;
            index++;
        }
        return sign*result;

    }
}