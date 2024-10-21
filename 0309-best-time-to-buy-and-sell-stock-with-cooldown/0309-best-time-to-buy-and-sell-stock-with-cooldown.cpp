class Solution {
public:
    // Custom hash function for unordered_map with pair<int, bool>
    struct pair_hash {
        template <class T1, class T2>
        std::size_t operator() (const std::pair<T1, T2>& p) const {
            return std::hash<T1>()(p.first) ^ std::hash<T2>()(p.second);
        }
    };

    unordered_map<pair<int, bool>, int, pair_hash> memo;

    int maxProfit(vector<int>& prices) {
        return dfs(0, true, prices);
    }

    int dfs(int index, bool canBuy, vector<int>& prices) {
        if (index >= prices.size()) return 0;

        // Check memoization
        if (memo.find({index, canBuy}) != memo.end()) {
            return memo[{index, canBuy}];
        }

        int coolDown = dfs(index + 1, canBuy, prices);  // Skip the current day
        if (canBuy) {
            // Option to buy
            int buyProfit = dfs(index + 1, false, prices) - prices[index];  // Buy today
            memo[{index, canBuy}] = max(buyProfit, coolDown);
        } else {
            // Option to sell
            int sellProfit = dfs(index + 2, true, prices) + prices[index];  // Sell today
            memo[{index, canBuy}] = max(sellProfit, coolDown);
        }

        return memo[{index, canBuy}];
    }
};
