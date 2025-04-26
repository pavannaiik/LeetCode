class Solution {
    public void merge(int[] nums1, int n, int[] nums2, int m) {
        int k = n+m-1;
        while(n-1>=0 && m-1 >=0){
            if(nums1[n-1] >= nums2[m-1]){
                nums1[k]=nums1[n-1];
                n--;
            }else{
                nums1[k]=nums2[m-1];
                m--;
            }
            k--;
        }
        while(n-1>=0){
            nums1[k]=nums1[n-1];
            n--;
            k--;
        }
        while(m-1 >=0){
            nums1[k]=nums2[m-1];
            m--;
            k--;
        }
    }
}