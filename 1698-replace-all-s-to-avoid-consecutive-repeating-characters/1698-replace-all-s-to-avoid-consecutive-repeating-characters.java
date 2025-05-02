class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        for(int i=0;i<n;i++){
            if(arr[i]=='?'){
                char prev = i==0? 'a': arr[i-1];
                char cur = (char)(prev +1 > 'z'?'a':prev+1);
                if(i+1  < n && cur == arr[i+1]){
                 cur = (char)(prev +2 > 'z'?'a':prev+2);
                 if(cur == arr[i+1]) cur = 'b';
                }
                arr[i] = cur;
            }
        }
        return String.valueOf(arr);
    }
}