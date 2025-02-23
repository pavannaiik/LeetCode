class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double totalTax =0;
        int n = brackets.length;
        for(int i=0;i<n;i++){
            if(i==0){
                totalTax = (Math.min(brackets[i][0], income)*((double)brackets[i][1]/100.0));
                income -= brackets[i][0];
            }else{
                totalTax += (Math.min(income, brackets[i][0]-brackets[i-1][0])*((double)brackets[i][1]/100.0));
                income -= (brackets[i][0]-brackets[i-1][0]);
            }
            if(income <=0) break;
        }
        return totalTax;
    }
}