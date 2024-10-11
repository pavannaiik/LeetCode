class Solution {
    public long dividePlayers(int[] skill) {
        int sum = 0;
        for (int s : skill) {
            sum += s;
        }
        int n = skill.length;

        // Check if the total sum can be divided into equal pairs
        if (sum % (n / 2) != 0) {
            return -1;
        }

        int req = sum / (n / 2);  // Required sum for each pair

        // Map to store frequencies of each skill
        Map<Integer, Integer> skillCount = new HashMap<>();
        for (int s : skill) {
            skillCount.put(s, skillCount.getOrDefault(s, 0) + 1);
        }

        long ans = 0;

        // Try to pair each skill
        for (int s : skill) {
            // If this skill has already been used up in pairing, skip it
            if (skillCount.get(s) == 0) {
                continue;
            }

            int complement = req - s; 

            // Check if the complement skill is available
            if (skillCount.getOrDefault(complement, 0) == 0) {
                return -1;  // If no complement, return -1
            }

            // Calculate the chemistry for this pair
            ans += (long) s * complement;

            // Decrease the count of both the current skill and its complement
            skillCount.put(s, skillCount.get(s) - 1);
            skillCount.put(complement, skillCount.get(complement) - 1);
        }

        return ans;
    }
}