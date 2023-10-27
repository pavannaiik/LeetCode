class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        cur =0
        left = 1
        right = 2**(n-1)
        for i in range(n-1):
            mid = (right+left)//2
            if k <= mid:
                right =mid
            else:
                left = mid+1
                cur = 1-cur
        return cur
        