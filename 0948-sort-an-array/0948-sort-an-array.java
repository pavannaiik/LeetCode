class Solution {
    public int[] sortArray(int[] nums) {
        int left =0, right =nums.length-1;
        sort(nums,left,right);
        return nums;
    }
    public void sort(int[] nums,int left, int right){
        if(left < right){
            int mid = (right+left)/2;
            sort(nums,left,mid);
            sort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }
    public void merge(int[] nums,int left,int mid,int right){
        int n1 = mid-left+1;
        int n2 = right - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0;i<n1;i++){
            L[i] = nums[left+i];
        }
        for(int i=0;i<n2;i++){
            R[i] = nums[mid+1+i];
        }
        int i=0,j=0;
        int k= left;
        while( i<n1 && j<n2 ){
            if(L[i] < R[j]){
                nums[k] = L[i];
                i++;
            }else{
                nums[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
                nums[k] = L[i];
                i++;
                k++;
         }
         while(j<n2){
                nums[k] = R[j];
                j++;
                k++;
         }
    }
}