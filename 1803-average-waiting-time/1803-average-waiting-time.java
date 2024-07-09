class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long ans =0;
        long end =0;
        for(int[] customer :customers ){
            long time = customer[0]+customer[1];
            long wait = time - customer[0];
            if(end > customer[0]){
                wait+= end-customer[0];
                end = time +(end-customer[0]);
            }else{
                end = time;
            }
            ans += wait;
            
        }
        return (double)(ans)/(double)n;
    }
}