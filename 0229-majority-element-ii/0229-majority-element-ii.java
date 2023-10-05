class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>res=new ArrayList();
// for any given array we can have atmost two elements which appear more than n/3
        int n=nums.length;
        int num1=-1,num2=-1,count1=0,count2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==num1) count1++;
            else if(nums[i]==num2) count2++;
            else if(count1==0){
                num1=nums[i];
                count1=1;
            }else if(count2==0){
                num2=nums[i];
                count2=1;
            }else {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        //count the number of num1s and num2s in the whole array
        for(int a:nums){
            if(a==num1) count1++;
            if(a==num2) count2++;
        }
        if(count1 > n/3)
            res.add(num1);
        if(count2 > n/3 && num1!=num2) // check if num1 and num2 are not equal 
            res.add(num2);
        return res;
        
    }
}