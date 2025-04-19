class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>>result = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
       int minNum =arr[0], maxNum = arr[0];
       for(int num:arr){
        minNum = Math.min(minNum, num);
        maxNum= Math.max(maxNum, num);
       }
       int range = maxNum-minNum+1;
       int shift = -minNum;
       int[] countArr = new int[range];
       for(int num:arr){
        countArr[num+shift]=1;
       }
       int prev =0;
       int maxPairDiff = maxNum-minNum;
       for(int cur=1;cur<=maxNum+shift;++cur){
         if(countArr[cur]==0) continue;
         if(cur-prev == maxPairDiff){
            result.add(List.of(prev-shift, cur-shift));
         }else if(cur-prev < maxPairDiff){
            result.clear();
            maxPairDiff = cur-prev;
           
            result.add(List.of(prev-shift, cur-shift));
         }
          prev = cur;
       }
       return result;
    }
}