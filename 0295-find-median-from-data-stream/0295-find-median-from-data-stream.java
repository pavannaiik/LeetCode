class MedianFinder {

    private final PriorityQueue<Integer> left = new PriorityQueue<>((a,b)->b-a);
    private final PriorityQueue<Integer> right = new PriorityQueue<>();
    private Integer middle = null;

    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if (middle != null){
            left.add(Math.min(num, middle));
            right.add(Math.max(num, middle));
            middle = null;
        }else if (left.isEmpty() && right.isEmpty()){
            middle = num;
        } else if (num < left.peek()){
            middle = left.remove();
            left.add(num);
        }else if (num > right.peek()){
            middle = right.remove();
            right.add(num);
        }else{
            middle = num;
        }

//        System.out.printf("After add %d, left=%s, mid=%s, right=%s\n", num, left, middle, right);
    }
    
    public double findMedian() {
        if (middle == null){
            return (left.peek() + right.peek()) / 2d;
        }else{
            return middle;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */