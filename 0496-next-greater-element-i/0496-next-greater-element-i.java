class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] indexArray = new int[10001];
        for(int i=0;i<nums2.length;i++){
            indexArray[nums2[i]] = i;
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]= findNextGrater(nums2,indexArray[nums1[i]]);
        }
        return nums1;
    }
    public int findNextGrater(int[] nums2, int index){
        for(int i=index;i<nums2.length;i++){
            if(nums2[i] > nums2[index]){
                return nums2[i];
            }
        }
        return -1;
    }
}