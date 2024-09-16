class Solution {
    
    public int[] timeTaken(int[] arrival, int[] state) {
        int n = arrival.length;
        int[] answer = new int[n];
        Queue<Integer>enter = new LinkedList<>();
        Queue<Integer>exit = new LinkedList<>();
        int lastDoorUsed =-1;
        for(int i=0;i<n;i++){
            if(state[i]==0){
                enter.add(i);
            }else{
                exit.add(i);
            }
        }
        int time;
        for(time =0;!enter.isEmpty()&& !exit.isEmpty();time++){
            if(arrival[enter.peek()]<=time && (arrival[exit.peek()]>time || lastDoorUsed==0) ){
                answer[enter.poll()] =time;
                lastDoorUsed = 0;
            }else if(arrival[exit.peek()] <= time){
                answer[exit.poll()] = time;
                lastDoorUsed = 1;
            }else{
                lastDoorUsed=-1;
            }
        }
        
        while(!enter.isEmpty()){
            if(arrival[enter.peek()]<=time){
                answer[enter.poll()]=time;
            }
            time++;
        }
        {
            while(!exit.isEmpty()){
                if(arrival[exit.peek()]<=time){
                    answer[exit.poll()]=time;
                }
                time++;
            }
        }
        return answer;
    }
}