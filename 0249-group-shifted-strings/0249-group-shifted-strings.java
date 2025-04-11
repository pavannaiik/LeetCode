class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>>result = new ArrayList<>();
        
        HashMap<String,List<String>>map = new HashMap<>();
        HashMap<String,Integer>countMap = new HashMap<>();
        for(String s: strings){
            StringBuilder sb = new StringBuilder(s);
            countMap.put(s, countMap.getOrDefault(s, 0)+1);
            if(map.containsKey(s))continue;
            map.put(s, new ArrayList<>());
            for(int i=0;i<26;i++){
                StringBuilder temp = new StringBuilder();
                for(char c:sb.toString().toCharArray()){
                    if(c=='z'){
                        temp.append('a');
                    }else{
                        temp.append((char)(c + 1));
                    }
                }
                sb = temp;
                map.get(s).add(temp.toString());
            }
        }
        HashMap<String,List<String>>groupMap = new HashMap<>();
        HashSet<String>visited = new HashSet<>();
        for(String key: map.keySet()){
            if (visited.contains(key))
                continue;

            List<String>keys = map.get(key);
            groupMap.putIfAbsent(key, new ArrayList<>());
            int count = countMap.get(key);
            while(count-- >0){
                 groupMap.get(key).add(key);
            }
            visited.add(key);
            for(String s: keys){
                if(map.containsKey(s) && !visited.contains(s)){
                    int cnt = countMap.get(s);
                    while(cnt-- >0){
                        groupMap.get(key).add(s);
                    }
                    
                    visited.add(s);
                }
            }
        }
        for(String key: groupMap.keySet()){
            if(groupMap.get(key).size()>0)
            result.add(groupMap.get(key));
        }

        return result;
    }
}