class Solution {
    public int maxWidthRamp(int[] nums) {
        int size = nums.length;
        Integer[] indices = new Integer[size];
        for(int i=0;i<size;i++){
            indices[i]=i;
        }
        Arrays.sort(indices, (i, j)->
            nums[i]!=nums[j]?nums[i]-nums[j]:i-j
        );

        int minIndex = size;
        int maxWidth = 0;
        for(int i:indices){
            maxWidth = Math.max(maxWidth, i-minIndex);
            minIndex = Math.min(minIndex, i);
        }
        return maxWidth;

    }
}