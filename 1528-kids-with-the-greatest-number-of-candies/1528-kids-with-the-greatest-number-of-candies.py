class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        highest = max(candies)
        boolVal = []
        for c in range(len(candies)):
            if candies[c] + extraCandies >= highest:
                boolVal.append(True)
            else:
                boolVal.append(False)

        return boolVal