class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int target=times[targetFriend][0];
        Arrays.sort(times, (a,b)->a[0]-b[0]);
        PriorityQueue<Person>pq=new PriorityQueue<>((a,b)->a.departure-b.departure);
        PriorityQueue<Integer>availableChairs=new PriorityQueue<>();
         int numPeople = times.length;
        for (int i = 0; i < numPeople; i++) {
            availableChairs.add(i); // Add chairs with indexes 0, 1, 2, ...
        }
        for(int[] time:times){
            int arrival = time[0];
            int departure = time[1];
            while(!pq.isEmpty() && arrival >= pq.peek().departure){
                availableChairs.add(pq.poll().chair);
            }
            if(target == arrival){
                return availableChairs.peek();
            }
            pq.add(new Person(departure, availableChairs.poll()));
        }
        return -1;

    }

}
class Person{
    public int departure;
    int chair;
    Person(int departure,int t){
        this.chair=t;
        this.departure=departure;
    }
}