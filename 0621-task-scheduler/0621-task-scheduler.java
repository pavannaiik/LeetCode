class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int totalJob = tasks.length;
        int highestCount=0;
        for(int task:tasks){
            map.put(task, map.getOrDefault(task, 0)+1);
            highestCount=Math.max(highestCount,map.get(task));
        }
        int X=0;
        for(int val:map.values()){
            if(val==highestCount) X++;
        }

        return Math.max(totalJob, (highestCount-1)*(n+1)+X);

    }
}

