class Solution {
public:
    int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int lastdigit = x % 10;
            
            // Check if multiplying by 10 or adding lastdigit would cause overflow
            if (ans > INT_MAX / 10 || (ans == INT_MAX / 10 && lastdigit > 7)) {
                return 0; // Overflow for positive numbers
            }
            if (ans < INT_MIN / 10 || (ans == INT_MIN / 10 && lastdigit < -8)) {
                return 0; // Overflow for negative numbers
            }
            
            ans = (ans * 10) + lastdigit;
            x /= 10;
        }
        return ans;
    }
};