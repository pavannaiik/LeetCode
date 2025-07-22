class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int n = s.length();
        int index = 0;
        int result = 0;
        while( index < n && s.charAt(index)==' ') index ++;
        if(index < n && s.charAt(index) == '+') {
            sign =1;
            index++;
        }
        else if( index < n && s.charAt(index) == '-'){
            sign = -1;
            index ++;
        }

        while(index < n){
            if(!Character.isDigit(s.charAt(index))) break;
            int digit = s.charAt(index) - '0';
            //check over flow
            if(result > ((Integer.MAX_VALUE - digit)/10)){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        return sign * result;
    }
}