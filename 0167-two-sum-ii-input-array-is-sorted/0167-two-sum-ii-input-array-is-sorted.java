class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int res[] = new int[2];
        int min=0,max=numbers.length-1;
        while(min< max){
            int total= numbers[min]+numbers[max];
            if(total==target){
                res[0]=min+1;
                res[1]=max+1;
                break;
            }
            if(total>target){
               max--;
            }else {
                min++;
            }
        }
        return res;
    }
}