class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] triplet = new int[3];
        for(int[] triplett : triplets){
            if(triplett[0] > target[0] || triplett[1] > target[1] || triplett[2] > target[2]){
                continue;
            }
           if(triplett[0] == target[0] ){
                triplet[0] = target[0];
            }
            if(triplett[1] == target[1] ){
                triplet[1] = target[1];
            }
            if(triplett[2] == target[2] ){
                triplet[2] = target[2];
            }

        }
        if(triplet[0] == target[0] && triplet[1] == target[1] && triplet[2] == target[2]){
                return true;
            }
            return false;
    }
}