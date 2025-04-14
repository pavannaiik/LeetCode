class Solution {
    public String addStrings(String num1, String num2) {
        int n = num2.length(), m = num1.length();
        int i=n-1, j=m-1;
        int carry =0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 && j>=0){
            char ch = num2.charAt(i);
            char c = num1.charAt(j);
            int num = (ch-'0' )+ (c -'0') + carry;
            if(num > 9){
                carry = num/10;
                num = num%10;
            }else carry =0;
            sb.insert(0,(char)(num+'0'));
            i--;
            j--;
        }
        while(i>=0){
            char ch = num2.charAt(i);
            int num = (ch-'0')  + carry;
            if(num > 9){
                carry = num/10;
                num = num%10;
            }else carry =0;
            sb.insert(0,(char)(num+'0'));
            i--;
        }
        while(j>=0){
            char ch = num1.charAt(j);
            int num = (ch-'0')  + carry;
            if(num > 9){
                carry = num/10;
                num = num%10;
            }else carry =0;
            sb.insert(0,(char)(num+'0'));
            j--;
        }
        if(carry > 0) sb.insert(0, carry);
        return sb.toString();
    }
}