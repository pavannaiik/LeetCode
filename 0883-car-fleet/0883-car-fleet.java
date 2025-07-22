class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] carFleet = new double[target+1];
        for(int i=0;i<speed.length;i++){
            carFleet[position[i]] = (double)(target-position[i])/speed[i];
        }
        int fleets =0;
        double maxSpeed = 0;
        for(int i= target;i>=0;i--){
            if(carFleet[i] > maxSpeed){
                maxSpeed = carFleet[i];
                fleets++;
            }
        }
        return fleets;
    }
}
