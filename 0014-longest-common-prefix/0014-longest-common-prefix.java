class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        res.append(strs[0]);
        for(int i = 1; i<strs.length; i++){
            int n = strs[i].length();
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j< n; j++){
                if(res.length()>j && strs[i].charAt(j)==res.charAt(j)){
                    temp.append(strs[i].charAt(j));
                } else break;
            }
            res = temp;
        }
        return res.toString();
    }
}