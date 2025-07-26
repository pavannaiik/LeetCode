class Solution {
    public boolean canArrange(int[] arr, int k) {
            int[] mp = new int[k]; // Equivalent to vector<int> mp(k, 0)

    for (int num : arr) {
        int rem = (num % k + k) % k; // Handles negative numbers correctly
        mp[rem]++;
    }

    if (mp[0] % 2 != 0) {
        return false;
    }

    for (int rem = 1; rem <= k / 2; rem++) {
        int counterHalf = k - rem;
        if (mp[rem] != mp[counterHalf]) {
            return false;
        }
    }

    return true;
    }
}