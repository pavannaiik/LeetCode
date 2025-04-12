class Solution {
    public int calculate(String s) {
        int result =0;
        int curVal =-1;
        int prevVal =0;
        char operator ='#';
        int i=0, j= s.length();
        while(i<j){
            char ch = s.charAt(i);
            if(Character.isWhitespace(ch)|| !Character.isDigit(ch)){
                if(!Character.isWhitespace(ch)) operator=ch;
                i++;
                continue;
            }else {
                int t = 0;
                while(i < j && Character.isDigit(s.charAt(i))){
                    t = t*10 + s.charAt(i)-'0';
                    i++;
                }
                curVal = t;

                if(operator == '+' || operator=='-'){
                    result += prevVal;
                    if(operator=='-') curVal = -1 * curVal;

                }else if(operator!='#'){
                    if(operator=='*') curVal = curVal*prevVal;
                    else curVal = curVal==0?0:prevVal/curVal;
                }

                prevVal = curVal;
                curVal =-1;
                operator = '#';
            }
        }
        return result+prevVal;
    }
}