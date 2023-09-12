class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int index = m+n-1;
        int mIndex =m-1, nIndex =n-1;
        
        while( nIndex >=0){
            if(mIndex>=0 && nums1[mIndex]>nums2[nIndex]){
                nums1[index--]=nums1[mIndex--];
            }else{
                nums1[index--]=nums2[nIndex--];
            }
        }
    }
}
