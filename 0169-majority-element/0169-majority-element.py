class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        num = nums[0]
        cnt = 1
        for i in range(1, len(nums)):
            if nums[i] == num:
                cnt += 1
            elif cnt == 0:
                num = nums[i]
                cnt = 1
            else:
                cnt -= 1
        return num
