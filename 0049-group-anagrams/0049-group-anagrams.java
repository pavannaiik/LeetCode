class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>list=new ArrayList<>();
        HashMap<String,List<String>>map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            char[] ch =s.toCharArray();
            Arrays.sort(ch);
            if(!map.containsKey(String.valueOf(ch))){
                map.put(String.valueOf(ch),new ArrayList<>());
            }
                map.get(String.valueOf(ch)).add(s);
            
        }
        
        return new ArrayList(map.values());
    }
}