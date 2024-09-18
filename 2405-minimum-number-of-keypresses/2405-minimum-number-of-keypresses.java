class Solution {
    public int minimumKeypresses(String s) {
        int[] arr= new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        Arrays.sort(arr);
        int count =0;
        int num=0;
        for(int i=25;i>=0;i--){
            if(arr[i] > 0){
                if(num<9) count+=arr[i];
                else if(num<18) count+= (arr[i]*2);
                else if(num >14) count+=(arr[i]*3);
                num++;
            }
        }
        return count;
    }
}