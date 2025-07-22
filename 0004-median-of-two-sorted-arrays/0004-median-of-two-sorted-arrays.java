class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(m < n){
            return findMedianSortedArrays(nums2, nums1);
        }
        int i =0 , j = n;
        while( i <= j){
            int partX = i+ (j-i)/2;
            int partY = (m+n+1)/2-partX;
            int partXMax = (partX==0)? Integer.MIN_VALUE: nums1[partX-1];
            int partXMin = (partX==n)?Integer.MAX_VALUE:nums1[partX];
            int partYMax = (partY==0)? Integer.MIN_VALUE: nums2[partY-1];
            int partYMin = (partY==m)?Integer.MAX_VALUE:nums2[partY];
            if( partYMax <= partXMin && partXMax <= partYMin){
                if((m+n)%2==0){
                    return (double)(Math.min(partXMin, partYMin) + Math.max(partXMax, partYMax))/2.0;
                }else{
                    return (double)(Math.max(partXMax, partYMax));
                }
            }else if(partXMin > partYMax){
                j = partX-1;
            }else{
                i= partX+1;
            }
        }
        return -1;
    }
}