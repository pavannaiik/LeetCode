class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        curMax = ans = nums[0]
        for num in nums[1:]:
            curMax = max(num+curMax,num)
            ans = max(ans,curMax)
        return ans
        