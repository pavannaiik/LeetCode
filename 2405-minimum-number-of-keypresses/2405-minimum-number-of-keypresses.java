class Solution {
    public int minimumKeypresses(String s) {
        Integer[] arr= new Integer[26];
        Arrays.fill(arr,0);
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        Arrays.sort(arr, (x,y)->y-x);
        int result = 0;
        for(int i = 0 ;i < 26; i++)
            result += arr[i] * ((i + 9)/9);
        return result;
    }
}