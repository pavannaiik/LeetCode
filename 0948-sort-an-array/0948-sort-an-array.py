class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        return self.merge_sort(nums)
    def merge_sort(self,cities):

        if len(cities) <= 1:
            return cities

        # Divide the list into two halves
        mid = len(cities) // 2
        left = cities[:mid]
        right = cities[mid:]

        # Recursively apply merge_sort to each half
        left = self.merge_sort(left)
        right = self.merge_sort(right)

        # Merge the two sorted halves
        result = []
        i = j = 0

        while i < len(left) and j < len(right):
            if left[i] <= right[j]:
                result.append(left[i])
                i += 1
            else:
                result.append(right[j])
                j += 1

        # Append remaining elements (if any)
        result.extend(left[i:])
        result.extend(right[j:])
        
        return result
        