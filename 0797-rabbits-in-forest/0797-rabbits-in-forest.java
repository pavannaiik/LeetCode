class Solution {
        public int numRabbits(int[] answers) {
        int c[] = new int[1000], res = 0;
        for (int i : answers)
            if (c[i]++ % (i + 1) == 0)
                res += i + 1;
        return res;
    }
}