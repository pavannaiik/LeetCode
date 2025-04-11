class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        
        // map: key (the original string, used as representative) -> list of all its rotated forms
        HashMap<String, List<String>> map = new HashMap<>();
        // countMap: count occurrences of each input string
        HashMap<String, Integer> countMap = new HashMap<>();
        
        // Build rotations for each new string (first occurrence)
        for (String s : strings) {
            // update count map
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
            
            // Only process the first occurrence of a string as key
            if (map.containsKey(s))
                continue;
            
            // Create list for rotations of s.
            List<String> rotations = new ArrayList<>();
            // Include the original string as the first rotation.
            rotations.add(s);
            
            // Use a StringBuilder to iteratively shift letters.
            StringBuilder sb = new StringBuilder(s);
            // We only need to generate 25 additional rotations (total 26 including the original)
            for (int i = 1; i < 26; i++) {
                StringBuilder temp = new StringBuilder();
                // Shift each character of sb by one (wrapping 'z' to 'a')
                for (char c : sb.toString().toCharArray()) {
                    if (c == 'z') {
                        temp.append('a');
                    } else {
                        temp.append((char)(c + 1));
                    }
                }
                sb = temp; // prepare for the next rotation
                rotations.add(temp.toString());
            }
            map.put(s, rotations);
        }
        
        // Build groups from the generated rotations.
        HashMap<String, List<String>> groupMap = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        
        // For each original string key that generated rotations,
        // group all strings which are present either as the key or as one of its rotations.
        for (String key : map.keySet()) {
            if (visited.contains(key))
                continue; // if already grouped, skip
            
            List<String> group = new ArrayList<>();
            // Add all copies of the key from the input.
            int count = countMap.get(key);
            while (count-- > 0) {
                group.add(key);
            }
            visited.add(key);
            
            // For each rotation of the key, if it exists as a key in our map and hasn't been visited,
            // add all its occurrences to the group.
            List<String> rotations = map.get(key);
            for (String rot : rotations) {
                if (map.containsKey(rot) && !visited.contains(rot)) {
                    int cnt = countMap.get(rot);
                    while (cnt-- > 0) {
                        group.add(rot);
                    }
                    visited.add(rot);
                }
            }
            groupMap.put(key, group);
        }
        
        // Add non-empty groups to the final result.
        for (String key : groupMap.keySet()) {
            if (groupMap.get(key).size() > 0)
                result.add(groupMap.get(key));
        }
        
        return result;
    }
}
