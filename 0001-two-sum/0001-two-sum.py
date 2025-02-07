class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        my_map = {}
        for i in range(len(nums)):
            req = target - nums[i]
            if req in my_map:
                return [my_map[req], i]
            my_map[nums[i]] = i

        return []
