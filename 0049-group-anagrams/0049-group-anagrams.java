class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>>map = new HashMap<>();
        for(String str:strs){
            char[] sortedChar = str.toCharArray();
            Arrays.sort(sortedChar);
            if(!map.containsKey(String.valueOf(sortedChar))){
                map.put(String.valueOf(sortedChar), new ArrayList<>());
            }
            System.out.println(String.valueOf(sortedChar));
            map.get(String.valueOf(sortedChar)).add(str);
        }
      List<List<String>>ans = new ArrayList<>();
      for(String st: map.keySet()){
        ans.add(map.get(st));
      }
      return ans;
    }
}