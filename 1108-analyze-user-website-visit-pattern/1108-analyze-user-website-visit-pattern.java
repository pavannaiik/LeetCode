class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // Step 1: Build a map of users to their visited websites with timestamps
        Map<String, List<Map.Entry<Integer, String>>> userVisits = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            userVisits.putIfAbsent(username[i], new ArrayList<>());
            userVisits.get(username[i]).add(Map.entry(timestamp[i], website[i]));
        }

        // Step 2: Sort the visits by timestamp for each user
        for (List<Map.Entry<Integer, String>> visits : userVisits.values()) {
            visits.sort(Map.Entry.comparingByKey());
        }

        // Step 3: Use a map to count the occurrences of each 3-sequence pattern
        Map<List<String>, Integer> patternCount = new HashMap<>();
        for (String user : userVisits.keySet()) {
            List<Map.Entry<Integer, String>> visits = userVisits.get(user);
            Set<List<String>> uniquePatterns = new HashSet<>();  // To avoid duplicate patterns for the same user

            int n = visits.size();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        List<String> pattern = List.of(visits.get(i).getValue(), visits.get(j).getValue(), visits.get(k).getValue());
                        if (uniquePatterns.add(pattern)) {
                            patternCount.put(pattern, patternCount.getOrDefault(pattern, 0) + 1);
                        }
                    }
                }
            }
        }

        // Step 4: Find the most visited pattern
        List<String> result = new ArrayList<>();
        int maxCount = 0;
        for (List<String> pattern : patternCount.keySet()) {
            int count = patternCount.get(pattern);
            if (count > maxCount || (count == maxCount && pattern.toString().compareTo(result.toString()) < 0)) {
                result = pattern;
                maxCount = count;
            }
        }

        return result;
    }
}
