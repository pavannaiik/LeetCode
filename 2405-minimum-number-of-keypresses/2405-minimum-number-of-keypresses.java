class Solution {
    public int minimumKeypresses(String s) {
        int[] arr= new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        Arrays.sort(arr);
        int count =0;
        for(int i=25;i>=0;i--){
            if(i <= 25 && i >16) count+=arr[i]*1;
            else if(i <=16 && i>7) count+= (arr[i]*2);
            else  count+=(arr[i]*3);
        }
        return count;
    }
}
