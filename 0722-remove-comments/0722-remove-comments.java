class Solution {
    public List<String> removeComments(String[] source) {
        List<String>res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode=false;
        for(String str : source){
            for(int i=0;i<str.length();i++){
                if(mode){
                    if(str.charAt(i)=='*' && i < str.length()-1 && str.charAt(i+1)=='/'){
                        mode=false;
                        i++; // ignoring next char of * ie /
                    }
                }else{
                    if(str.charAt(i)=='/' && i < str.length()-1 && str.charAt(i+1)=='/'){
                        break;
                    }else if(str.charAt(i)=='/' && i < str.length()-1 && str.charAt(i+1)=='*'){
                        mode=true;
                        i++; // ignoring comment *
                    }else{
                        sb.append(str.charAt(i));
                    }
                }
            }
            if(!mode && sb.length()>0){
                res.add(sb.toString());
                sb = new StringBuilder();
            }
            
            
        }
        return res;
    }
}