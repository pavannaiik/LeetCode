
class Solution {
    public int maxEvents(int[][] events) {
        // Sort events by start time, if same start time then by end time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min-Heap to store event end times
        int i = 0, n = events.length, maxDays = 0, attended = 0;

        // Find max day among all events
        for (int[] event : events) {
            maxDays = Math.max(maxDays, event[1]);
        }

        // Iterate over all possible days
        for (int day = 1; day <= maxDays; day++) {
            // Add all events that start on this day to the min-heap
            while (i < n && events[i][0] == day) {
                minHeap.add(events[i][1]);
                i++;
            }

            // Remove expired events
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend the event that ends the earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }
        }
        return attended;
    }
}
