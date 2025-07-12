class Solution {
    List<String>ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        HashMap<Character, List<Character>>map = new HashMap<>();
        map.put('2', List.of('a','b','c'));
        map.put('3', List.of('d','e','f'));
        map.put('4', List.of('g','h','i'));
        map.put('5', List.of('j','k','l'));
        map.put('6', List.of('m','n','o'));
        map.put('7', List.of('p','q','r','s'));
        map.put('8', List.of('t','u','v'));
        map.put('9', List.of('w','x','y','z'));
        getLetterCombinations(digits, 0, digits.length(), new StringBuilder(),map);
        return ans;
    }
    public void getLetterCombinations(String digits, int index, int n, 
    StringBuilder sb, HashMap<Character, List<Character>>map){
        if(sb.length() == n){
            ans.add(sb.toString());
            return;
        }
        List<Character>curList = map.get(digits.charAt(index));
        for(Character c: curList){
            sb.append(c);
            getLetterCombinations(digits, index+1, n, sb, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}