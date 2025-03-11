class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Double> sortedMap=new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<position.length;i++){
            sortedMap.put(position[i],(double)(target-position[i])/speed[i]);
        }
        int res=0;
        double curTime=0;
        for(Double time : sortedMap.values()){
            if(time> curTime){
                curTime = time;
                res++;
            }
        }
        return res;
    }
}