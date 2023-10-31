class Solution:
    def findArray(self, pref: List[int]) -> List[int]:
        a = pref[0]
        arr = []
        arr.append(a)
        for i in pref[1:]:
            cur = a ^ i
            arr.append(cur)
            a = a^ cur
        return arr

        