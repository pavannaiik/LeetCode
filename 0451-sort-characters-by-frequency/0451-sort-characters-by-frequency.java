class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int maxFreq = Collections.max(map.values());
        List<List<Character>>buckets = new ArrayList<>();
        for(int i=0;i<=maxFreq;i++){
            buckets.add(new ArrayList<Character>());
        }
        for(Character key:map.keySet()){
            int freq = map.get(key);
            buckets.get(freq).add(key);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=buckets.size()-1;i>=1;i--){
            for(Character c:buckets.get(i)){
                for(int j=0;j<i;j++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}