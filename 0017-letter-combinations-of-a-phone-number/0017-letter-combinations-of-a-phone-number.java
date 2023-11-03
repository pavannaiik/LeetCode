import java.util.Map;
class Solution {
    private List<String>result = new ArrayList<>();
    private final Map<Character,String>map = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz");
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return result;
        backtrack(digits, 0, new StringBuilder());
        return result;
    }
    public void backtrack(String digits, int index, StringBuilder sb){
        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }
        String temp = map.get(digits.charAt(index));
        for(char ch: temp.toCharArray()){
            sb.append(ch);
            backtrack(digits, index+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}