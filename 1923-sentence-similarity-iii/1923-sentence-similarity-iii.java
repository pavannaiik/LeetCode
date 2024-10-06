class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] first = sentence1.split(" ");
        String[] second = sentence2.split(" ");
        
        // If first is longer, swap so that we always process the shorter one first
        if (first.length < second.length) {
            String[] temp = first;
            first = second;
            second = temp;
        }
        
        int i = 0, j = 0;
        
        // Start from the beginning and match as much as possible
        while (i < second.length && first[i].equals(second[i])) {
            i++;
        }
        
        // Start from the end and match as much as possible
        while (j < second.length && first[first.length - 1 - j].equals(second[second.length - 1 - j])) {
            j++;
        }
        
        // If all words match, the sentences are similar
        return i + j >= second.length;
    }
}
