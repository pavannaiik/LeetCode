class Solution {
    public String addStrings(String num1, String num2) {

        String[] firstString = num1.split(".");
        String[] secondString = num2.split(".");
        boolean hasDecimal = false;

        if(firstString.length >1 || secondString.length>1){
            hasDecimal=true;
        }
        if(!hasDecimal){
            Result r =  helper(num1,num2, 0);
            StringBuilder str = new StringBuilder(r.stringValue);
            if(r.intValue > 0){
                str.append(r.intValue);
            }
            return str.reverse().toString();
            
        }
        StringBuilder sb1 = new StringBuilder(firstString[1]);
        StringBuilder sb2 = new StringBuilder(secondString[1]);
        if(sb1.length() > sb2.length()){
            while(sb1.length() != sb2.length()){
                sb2.append('0');
            }
        }else{
            while(sb1.length() != sb2.length()){
                sb1.append('0');
            }
        }
        Result r =  helper(sb1.toString(),sb2.toString(), 0);
        StringBuilder str = new StringBuilder(r.stringValue);
        str.append('.');
        Result r2 = helper(firstString[0], secondString[0], r.intValue);
        StringBuilder str1 = new StringBuilder(r2.stringValue);
        if(r2.intValue > 0){
            str1.append(r2.intValue);
        }
        str.append(str1);
        return str.reverse().toString();

    }
    public Result helper(String num1, String num2, int carry){
        int n = num2.length(), m = num1.length();
        int i=n-1, j=m-1;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0 ){
            int num = carry;
            if(i >=0 ){
                num += num2.charAt(i)-'0';
                i--;
            }
            if(j >=0){
                num += num1.charAt(j)-'0';
                j--;
            }
            carry = num/10;
            sb.append(num%10);
        }
        return new Result(carry, sb.toString());
    }
}
class Result {
    int intValue;
    String stringValue;

    Result(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }
}