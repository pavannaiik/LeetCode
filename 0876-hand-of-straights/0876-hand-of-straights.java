class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        Arrays.sort(hand);  // Sort the hand to always start from smallest available card

        HashMap<Integer, Integer> countCards = new HashMap<>();
        for (int card : hand) {
            countCards.put(card, countCards.getOrDefault(card, 0) + 1);
        }

        for (int card : hand) {
            if (countCards.get(card) == 0) continue;  // Already used this card in some group

            // Try to build a group starting at current card
            for (int i = 0; i < groupSize; i++) {
                int nextCard = card + i;
                if (countCards.getOrDefault(nextCard, 0) == 0) return false;
                countCards.put(nextCard, countCards.get(nextCard) - 1);
            }
        }

        return true;
    }
}
