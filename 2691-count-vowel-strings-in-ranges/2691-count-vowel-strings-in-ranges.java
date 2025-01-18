class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] left=new int[words.length];
        int cnt =0;
        int i=0;
        for(String s:words){
            if(s.charAt(0)=='a' || s.charAt(0)=='e' || s.charAt(0)=='i'
               || s.charAt(0)=='o' || s.charAt(0)=='u'){
                if(s.charAt(s.length()-1)=='a' || s.charAt(s.length()-1)=='e' || s.charAt(s.length()-1)=='i'
               || s.charAt(s.length()-1)=='o' || s.charAt(s.length()-1)=='u'){
                cnt++;
               }
               }
               left[i++]=cnt;
        }
        int[] result=new int[queries.length];
        int p=0;
        for(int[] query: queries){
            int start = query[0];
            int end = query[1];
            if(start==0){
                result[p++]=left[end];
                continue;
            }
            result[p++]=left[end]-left[start-1];

        }
        return result;
    }
}