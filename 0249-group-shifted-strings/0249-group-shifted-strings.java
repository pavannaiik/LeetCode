class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String,List<String>>map = new HashMap<>();
        List<List<String>>result = new ArrayList<>();
        for(String s:strings){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                int diff = c-s.charAt(0);
                if(diff<0){
                    diff = diff+25+1;
                }
                sb.append(diff);
                sb.append(',');
            }
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(s);
        }
        for(String key:map.keySet()){
            result.add(map.get(key));
        }
        return result;

    }
}