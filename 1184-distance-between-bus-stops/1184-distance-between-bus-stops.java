class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int tdc =0,tdac=0;
        int n = distance.length;
        if(start >= destination){
            int temp = start;
            start = destination;
            destination = temp;
        }
        for(int i=0;i<n;i++){
            if(i >=start && i<destination){
                tdc+=distance[i];
            }
            tdac += distance[i];
        }
        return Math.min(tdc,tdac-tdc);
    }
}