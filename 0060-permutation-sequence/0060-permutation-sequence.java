class Solution {
   
    public String getPermutation(int n, int k) {
       List<Integer>numbers = new ArrayList<>();
       int[] factorial = new int[n+1];
       factorial[0]=1;
       for(int i=1;i<=n;i++){
        factorial[i]= factorial[i-1]*i;
        numbers.add(i);
       }
       //since we are dealing with zero base index we reduce k=k-1

       k=k-1;
       StringBuilder sb = new StringBuilder();
       for(int i=1;i<=n;i++){
        //basically we will have factorial[n-i] variations 
        //sequence starting with i
        int index = k/factorial[n-i];
        sb.append(String.valueOf(numbers.get(index)));
        numbers.remove(index);
        //since we are interested in numbers starting at index
        //we need to ignore all numbers before index
        k = k-index * factorial[n-i];
       }
       return sb.toString();
    }
    
}