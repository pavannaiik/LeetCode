class Solution {
    List<List<String>>ans;
    public List<List<String>> partition(String s) {
       ans = new ArrayList<>();
        recur(s, 0, new ArrayList<>());
        return ans;
    }
    public void recur(String s, int index, List<String>temp){
        if(index>=s.length()){
            ans.add(new ArrayList<>(temp));
        }else{
            for(int i=index;i<s.length();i++){
                if(isPalindrome(index, i,s)){
                    temp.add(s.substring(index,i+1));
                    recur(s, i+1, temp);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
     public boolean isPalindrome(int start, int end, String s){
        while(start < end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}