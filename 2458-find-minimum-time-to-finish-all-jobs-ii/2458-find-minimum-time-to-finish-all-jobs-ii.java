class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int cnt =0;
        for(int i=jobs.length-1;i>=0;i--){
           cnt = Math.max(cnt, (int)Math.ceil((double)jobs[i]/workers[i]));
        }
        return cnt;

    }
}