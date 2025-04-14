class Solution {
    public String addStrings(String num1, String num2) {

        String[] firstString = num1.split(".");
        String[] secondString = num2.split(".");
        boolean hasDecimal = false;

        if(firstString.length >1 || secondString.length>1){
            hasDecimal=true;
        }
        if(!hasDecimal){
            return helper(num1, num2);
        }else return "";

    }
    public String helper(String num1, String num2){
        int n = num2.length(), m = num1.length();
        int i=n-1, j=m-1;
        int carry =0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0 || carry !=0){
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
        return sb.reverse().toString();
    }
}