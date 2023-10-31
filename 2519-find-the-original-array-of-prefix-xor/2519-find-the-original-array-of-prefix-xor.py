class Solution:
    def findArray(self, pref: List[int]) -> List[int]:
        arr = []
        next_num = 0
        for num in pref:
            arr.append(num ^ next_num)
            next_num = num
        return arr

        