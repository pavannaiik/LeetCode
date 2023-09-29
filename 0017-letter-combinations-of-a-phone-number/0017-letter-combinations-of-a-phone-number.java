class Solution {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String phoneDigits;
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return combinations;
        backtrack(digits,0,new StringBuilder());
        return combinations;
    }
    public void backtrack(String s,int index,StringBuilder res){
        if(res.length()==s.length()){
            combinations.add(res.toString());
            return;
        }
            String temp = letters.get(s.charAt(index));
            for(char ch:temp.toCharArray()){
                res.append(ch);
                backtrack(s,index+1, res);
                res.deleteCharAt(res.length()-1);
            }
        return;
    }
}