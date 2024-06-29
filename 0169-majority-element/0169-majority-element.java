class Solution {
    //Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
       int count =0;
       Integer num = null;
       for(int number:nums){
         if(count == 0){
            num = number;
         }
         if(number == num){
            count++;
         }else{
            count--;
         }
       }
       return num;
    }
}