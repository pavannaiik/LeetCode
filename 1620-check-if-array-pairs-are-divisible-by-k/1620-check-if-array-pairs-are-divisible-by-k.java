import java.util.*;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> countingMap = new HashMap<>();

        // Step 1: Count occurrences of each remainder when divided by k
        for (int n : arr) {
            int remainder = ((n % k) + k) % k;  // Handle negative numbers
            countingMap.put(remainder, countingMap.getOrDefault(remainder, 0) + 1);
        }

        // Step 2: Check if pairs can be formed
        for (int key : countingMap.keySet()) {
            // Special case: numbers divisible by k must have even count
            if (key == 0) {
                if (countingMap.get(key) % 2 != 0) {
                    return false;
                }
            } else {
                int complement = k - key;
                if (!countingMap.containsKey(complement) || !countingMap.get(key).equals(countingMap.get(complement))) {
                    return false;
                }
            }
        }

        return true;
    }
}
