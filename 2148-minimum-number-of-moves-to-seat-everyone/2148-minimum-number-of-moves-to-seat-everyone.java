class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int maxValue =0;
        for(int seat:seats){
            maxValue= Math.max(maxValue, seat);
        }
        for(int student:students){
            maxValue= Math.max(maxValue, student);
        }
        int[] countArray = new int[maxValue];
        for(int seat:seats){
            countArray[seat-1]++;
        }
        for(int student:students){
            countArray[student-1]--;
        }
        // Calculate the number of moves needed to seat the students
        int moves = 0;
        int unmatched = 0;
        for (int difference : countArray) {
            moves += Math.abs(unmatched);
            unmatched += difference;
        }

        return moves;
        
    }
}