class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int k= arr.length-1;
        for(String st : arr){
            for(int i=st.length()-1;i>=0;i--){
                sb.append(st.charAt(i));
            }
            sb.append(" ");
        }
        return sb.substring(0,s.length()).toString();
    }
}