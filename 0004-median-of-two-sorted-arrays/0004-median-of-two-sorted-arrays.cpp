class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() > nums2.size()){
            return findMedianSortedArrays(nums2, nums1);
        }
        int n=nums1.size(),m=nums2.size();
        int l=0, r=nums1.size();
        while(true){
            int partX = (l+r)/2;
            int partY =(n+m+1)/2-partX;

            int maxX = (partX==0)?INT_MIN:nums1[partX-1];
            int maxY = (partY==0)?INT_MIN:nums2[partY-1];
            int minX=(partX==n)?INT_MAX:nums1[partX];
            int minY=(partY==m)?INT_MAX:nums2[partY];

            if(maxX <= minY && maxY <=minX){
                if((n+m)%2==0){
                    return double(max(maxX,maxY)+min(minX,minY))/2;
                }else{
                    return double(max(maxX,maxY));
                }
            }else if(maxX > minY){
                r=partX-1;
            }else{
                l=partX+1;
            }
        }
        return 1.0;
    }
};