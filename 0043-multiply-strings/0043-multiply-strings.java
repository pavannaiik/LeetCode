class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] answer = new int[m+n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                answer[i+j] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                answer[i+j+1] += answer[i+j]/10;
                answer[i+j] = answer[i+j]%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=m+n-1;i>=0;i--){
            if(sb.length()==0 && answer[i]==0) continue;
            sb.append(answer[i]);
        }
        if(sb.isEmpty()) return "0";
        else return sb.toString();
    }
}