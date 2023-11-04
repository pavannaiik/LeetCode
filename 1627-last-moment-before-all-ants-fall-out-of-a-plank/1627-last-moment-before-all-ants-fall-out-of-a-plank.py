class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        ans = 0
        for val in left:
            ans = max(ans,val)
        for val in right:
            ans = max(n-val, ans)
        return ans