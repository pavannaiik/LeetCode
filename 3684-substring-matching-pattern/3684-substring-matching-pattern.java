class Solution {
    public boolean hasMatch(String s, String p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int flag=0;
        for(char c: p.toCharArray()){
            if(c=='*'){
               flag=1;
               continue;
            }
            if(flag==0)
            sb.append(c);
            else sb2.append(c);
        }
        int index = s.indexOf(sb.toString());
        if(index==-1) return false;
        String str = s.substring(index+sb.length());
        int index2= str.indexOf(sb2.toString());
        if(index2==-1) return false;
        return true;

    }
}