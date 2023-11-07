class SeatManager {
    PriorityQueue<Integer>pq;
    int ans;
    public SeatManager(int n) {
        ans =1;
        pq = new PriorityQueue<>();
        
    }
    
    public int reserve() {
        if(pq.size()==0) return ans++;
        return pq.poll();
    }
    
    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */