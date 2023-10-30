class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        bits = [[] for _ in range(15)]
        for i in arr:
            no_of_bits =0
            k =i
            while k!=0:
                if k & 1==1:
                    no_of_bits+=1
                k = k>>1
            bits[no_of_bits].append(i)
    
        ans = []
        for value in bits:
            ans.extend(sorted(value))
        return ans

        