class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int len = arrival.length;
        int[] ans = new int[len];
        int lastDoorUsed =-1;
        Queue<Integer>enter = new LinkedList<>();
        Queue<Integer>exit = new LinkedList<>();
        for(int i=0;i<len;i++){
            if(state[i]==0) enter.add(i);
            else exit.add(i);
        }
        int time;
        for(time=0; !exit.isEmpty() && !enter.isEmpty() ; time++){
            if(arrival[enter.peek()] <= time && (arrival[exit.peek()]>time || lastDoorUsed==0 )){
                ans[enter.poll()]= time;
                lastDoorUsed =0;
            }else if(arrival[exit.peek()] <= time){
                ans[exit.poll()]=time;
                lastDoorUsed = 1;
            }else{
                lastDoorUsed =-1;
            }
        }
        while(!enter.isEmpty()){
            if(arrival[enter.peek()] <= time){
                ans[enter.poll()]= time;
            }
            time++;
        }
        while(!exit.isEmpty()){
            if(arrival[exit.peek()] <= time){
                ans[exit.poll()]= time;
            }
            time++;
        }
        return ans;
    }
}