class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       if(nums2.length<nums1.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int start=0,end=nums1.length;
        while(start<=end){
            int parX=(start+end)/2;
            int parY=(nums1.length+nums2.length+1)/2-parX;
            int maxX=(parX==0)?Integer.MIN_VALUE:nums1[parX-1];
            int minX=(parX==nums1.length)?Integer.MAX_VALUE:nums1[parX];
            int maxY=(parY==0)?Integer.MIN_VALUE:nums2[parY-1];
            int minY=(parY==nums2.length)?Integer.MAX_VALUE:nums2[parY];
            if(maxX<=minY && maxY<=minX){
                if((nums1.length+nums2.length)%2==0){
                    return (Math.max(maxX,maxY)+Math.min(minX,minY))/2.0;
                }else{
                    return (double)(Math.max(maxX,maxY));
                }
            }else if(maxX>minY){
                end=parX-1;
            }else{
                start=parX+1;
            }
        }
        return -1;
    }
}