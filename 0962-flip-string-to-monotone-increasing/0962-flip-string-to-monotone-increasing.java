class Solution {
    public int minFlipsMonoIncr(String s) {
        int flips = 0;
        int onesCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                // Either flip this 0 to 1 or keep it and flip all previous 1's
                flips = Math.min(flips + 1, onesCount);
            } else {
                onesCount++;
            }
        }

        return flips;
    }
}
