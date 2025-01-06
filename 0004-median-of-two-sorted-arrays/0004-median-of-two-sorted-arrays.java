class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int n=nums1.length, m = nums2.length;
        int i=0, j=n;
        while(i<=j){
            int partX = i+(j-i)/2;
            int partY = (m+n+1)/2-partX;
            int maxX = partX==0?Integer.MIN_VALUE:nums1[partX-1];
            int minX = partX==n?Integer.MAX_VALUE:nums1[partX];
            int maxY = partY==0?Integer.MIN_VALUE:nums2[partY-1];
            int minY = partY==m?Integer.MAX_VALUE:nums2[partY];
            if(maxX <= minY && maxY <= minX){
                if((n+m)%2==0){
                    return (double) (Math.max(maxX,maxY)+Math.min(minX,minY))/2.0;
                }else{
                    return (double) Math.max(maxX,maxY);
                }
            }else if(minX > maxY){
                j = partX-1;
            }else{
                i= partX+1;
            }
        }
        return -1;
    }
}