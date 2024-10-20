class MedianFinder {
public:
    priority_queue<int,vector<int>,greater<int>>minHeap;
    priority_queue<int>maxHeap;
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        if (maxHeap.empty() || num <= maxHeap.top()) {
            maxHeap.push(num);  // Insert into maxHeap if it's smaller
        } else {
            minHeap.push(num);  // Otherwise, insert into minHeap
        }
        
        // Now, rebalance the heaps so that the size difference is at most 1
        if (maxHeap.size() > minHeap.size() + 1) {
            // Move the top element from maxHeap to minHeap
            minHeap.push(maxHeap.top());
            maxHeap.pop();
        } else if (minHeap.size() > maxHeap.size()) {
            // Move the top element from minHeap to maxHeap
            maxHeap.push(minHeap.top());
            minHeap.pop();
        }
        
    }
    
    double findMedian() {
        int n = maxHeap.size();
        int m=minHeap.size();
        if(n==0 && m==0) return 0.0;
        if ((n + m) % 2 == 0) {
            // If the total number of elements is even, return the average of the top elements of both heaps
            return (maxHeap.top() + minHeap.top()) / 2.0;
        } else {
            // If odd, return the top of maxHeap (it will have one more element)
            return maxHeap.top();
        }
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */