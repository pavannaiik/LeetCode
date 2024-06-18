// class Solution {
//     public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
//         int ans =0;
//         for(int work:worker){
//             ans+= getProfit(work, difficulty,profit);
//         }
//         return ans;
//     }
//     public int getProfit(int work,int[] difficulty, int[] profit ){
//         int i=0, j= difficulty.length-1;
//         while(i<j){
//             int mid  = i+(j-i)/2;
//             if(difficulty[mid]<work){
//                 i=mid;
//             }else {
//                 j=mid-1;
//             }
//         }
//         return profit[i];
//     }
// }

import java.util.Arrays;

public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        // Create a 2D array to pair difficulty and profit and then sort it by difficulty
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Update the profit to be the maximum profit up to that difficulty
        for (int i = 1; i < n; i++) {
            jobs[i][1] = Math.max(jobs[i][1], jobs[i - 1][1]);
        }

        // Sort the workers
        Arrays.sort(worker);

        int ans = 0;
        int j = 0;
        for (int ability : worker) {
            // Use binary search to find the maximum profit this worker can achieve
            while (j < n && jobs[j][0] <= ability) {
                j++;
            }
            if (j > 0) {
                ans += jobs[j - 1][1];
            }
        }
        return ans;
    }
}
