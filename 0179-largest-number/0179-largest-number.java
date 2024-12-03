class Solution {
    private class LargerNumberComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String order1 = a+b;
            String order2 = b+a;
            return order2.compareTo(order1);
        }
    }
    public String largestNumber(int[] nums) {
        String[] asString = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            asString[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(asString, new LargerNumberComparator());
        //after sorting if the largest number is zero then all zeros
        if(asString[0].equals("0")) return "0";
        String ans = new String();
        for(String curStr:asString){
            ans += curStr;
        }
        return ans;
    }
}