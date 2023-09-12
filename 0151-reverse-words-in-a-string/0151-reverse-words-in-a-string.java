class Solution {
    public String reverseWords(String s) {
        String[] res = s.split(" ");
        StringBuilder sb= new StringBuilder();
        
        for(int i=res.length-1;i>=0;i--){
            System.out.println(res[i]);
            if(!res[i].equals(""))
            sb.append(res[i]);
            if(i-1>=0 && !res[i-1].equals(""))
                sb.append(" ");
        }
        return sb.toString();
    }
}