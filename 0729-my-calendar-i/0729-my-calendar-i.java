class MyCalendar {
    List<int[]>calender;
    public MyCalendar() {
        calender=new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] event:calender){
            if(startTime < event[1] && event[0]< endTime) return false;
        }
        calender.add(new int[]{startTime,endTime});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */