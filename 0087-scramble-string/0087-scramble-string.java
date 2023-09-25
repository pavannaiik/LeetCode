class Solution {
    public boolean isScramble(String s1, String s2) {
        //perform split at all the lengths and swap the x & y or dont swap
        //using dp 
        HashMap<String,Boolean>map = new HashMap<>();
        return isScram(s1,s2,map);
    }
    public boolean isScram(String str,String s2,HashMap<String,Boolean>map){
        if(str.length()==1){
            return str.equals(s2);
        }
        
        if(str.equals(s2)) return true;
        String key = str+s2;
        if(map.containsKey(key)){
            return map.get(key);
        }
        boolean flag =false;
        int length = str.length();
        for(int i=1;i<length;i++){
            if((isScram(str.substring(0,i),s2.substring(0,i),map) && isScram(str.substring(i),s2.substring(i),map)) || (isScram(str.substring(0,i),s2.substring(length-i),map) && isScram(str.substring(i),s2.substring(0,length-i),map))){
                flag = true;
                break;
            }
           
        }
         map.put(key,flag);
        return flag;
        
    }
}