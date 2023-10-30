class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: x[0])
        heap = []
        min_num_of_machines_required = 0

        for interval in intervals:
            start_time, end_time = interval
            while heap and heap[0] < start_time:
                heapq.heappop(heap)
            heapq.heappush(heap, end_time)
            min_num_of_machines_required = max(min_num_of_machines_required, len(heap))

        return min_num_of_machines_required
        