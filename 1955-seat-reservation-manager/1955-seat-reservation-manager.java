class SeatManager {
    SortedSet<Integer> ts;
    int mark;
    public SeatManager(int n) {
           ts = new TreeSet<Integer>();
           mark = 1;
    }
    
    public int reserve() {
        if(!ts.isEmpty()){
            int seat =  ts.first();
            ts.remove(seat);
            return seat;
        }else{
            int seat = mark;
            mark++;
            return seat;
        }
        
    }
    
    public void unreserve(int seatNumber) {
        ts.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */