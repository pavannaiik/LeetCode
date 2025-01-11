class Solution {
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;  // Number of even indices
        long oddCount = n / 2;          // Number of odd indices

        long evenDigits = fastPower(5, evenCount, MOD);
        long oddDigits = fastPower(4, oddCount, MOD);

        return (int) ((evenDigits * oddDigits) % MOD);
    }

    // Fast exponentiation: (base^exp) % mod
    private long fastPower(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
}
