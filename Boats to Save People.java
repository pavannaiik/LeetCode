class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int c=0,i=0,j=people.length-1;
       while(i<=j){
           c++;
            if(people[i]+people[j]<=limit)
                i++;
           j--;
        }
        return c;
    }
}