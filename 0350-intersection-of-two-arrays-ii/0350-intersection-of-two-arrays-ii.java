class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //if array is sorted then
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer>ans = new ArrayList<>();
       int i=0,j=0,n=nums1.length,m=nums2.length;
       while(i<n && j<m){
        if(nums1[i]==nums2[j]){
            ans.add(nums1[i]);
            i++;
            j++;
        }else if(nums1[i]>nums2[j]){
            j++;
        }else{
            i++;
        }
       }
       int[] res = new int[ans.size()];
        int k=0;
        for(int num:ans){
            res[k++]=num;
        }
        return res;
    }
}