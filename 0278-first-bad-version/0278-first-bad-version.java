/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long i=0,j=n;
        while(i<j){
            long mid=(i+j)/2;
            if(isBadVersion((int)mid)){
                j=mid;
            }else{
                i=mid+1;
            }
        }
        return (int)i;
            
    }
}