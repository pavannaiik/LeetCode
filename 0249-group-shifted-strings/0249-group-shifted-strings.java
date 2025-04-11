class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s : strings) {
            // Compute a normalized shift key for each string
            String key = getShiftKey(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        // Return the groups as a list of lists
        return new ArrayList<>(map.values());
    }
    
    private String getShiftKey(String s) {
        StringBuilder key = new StringBuilder();
        char firstChar = s.charAt(0);
        
        for (char c : s.toCharArray()) {
            // Use modulo arithmetic to handle the wrap-around from 'z' to 'a'
            int diff = (c - firstChar + 26) % 26;
            key.append(diff).append(',');
        }
        
        return key.toString();
    }
}
