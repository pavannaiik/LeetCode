class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max= Arrays.stream(piles).max().getAsInt();
        int min = 1;
        while( min < max){
            int mid = min+(max-min)/2;
            if(check(piles, mid, h)){
                max = mid;
            }else{
                min=mid+1;
            }
        }
        return min;
    }
    public boolean check(int[] piles, int mid, int h){
        int total=0;
        for(int pile:piles){
            if(pile%mid!=0)
            total +=1;
            total += pile/mid;
        }
        return total <= h;
    }
}