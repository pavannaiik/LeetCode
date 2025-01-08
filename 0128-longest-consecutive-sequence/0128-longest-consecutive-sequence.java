class Solution {
    public int longestConsecutive(int[] nums) {
        int len =0;
        HashSet<Integer>set = new HashSet<>();
        for(int num:nums) set.add(num);
        for(int num:nums){
            if(set.contains(num+1)){
                continue;
            }
            int curNum = num;
            int lenCur=0;
            while(set.contains(curNum)){
                lenCur ++;
                set.remove(curNum);
                curNum -=1;
            }
            len = Math.max(len, lenCur);
        }
        return len;
    }
}