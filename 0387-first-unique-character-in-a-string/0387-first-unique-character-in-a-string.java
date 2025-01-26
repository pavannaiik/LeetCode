class Solution {
    public int firstUniqChar(String s) {
        for(char c:s.toCharArray() ){
            int index = s.indexOf(c);
            if(index!=-1 && index == s.lastIndexOf(c)){
                return index;
            }
        }
        return -1;
    }
}