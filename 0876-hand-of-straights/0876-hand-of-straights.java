class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer>countCards = new HashMap<>();
        Arrays.sort(hand);
        int n = hand.length;
        if(n%groupSize != 0) return false;
        for(int card:hand){
            countCards.put(card, countCards.getOrDefault(card, 0)+1);
        }
        for(int card: hand){
            if(countCards.getOrDefault(card,0)==0) continue;
            for(int nextCard = card;nextCard < card + groupSize;nextCard++){
                if(countCards.getOrDefault(nextCard, 0) == 0) return false;
                countCards.put(nextCard, countCards.get(nextCard)-1);
            }
        }
        return true;
    }
}