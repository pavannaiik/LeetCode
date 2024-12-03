class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        // Insert the number into the list and maintain sorted order
        int pos = Collections.binarySearch(list, num);
        if (pos < 0) pos = -(pos + 1);
        list.add(pos, num);
    }
    
    public double findMedian() {
        int n = list.size();
        if (n % 2 == 0) {
            return (list.get(n / 2) + list.get(n / 2 - 1)) / 2.0;
        } else {
            return list.get(n / 2);
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */