class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] ch = s.toCharArray();
        int left = 0, right = ch.length - 1;
        int moves = 0;

        while (left < right) {
            if (ch[left] == ch[right]) {
                left++;
                right--;
            } else {
                int k = right;
                while (k > left && ch[k] != ch[left]) {
                    k--;
                }

                if (k == left) {
                    // No matching character found, swap with next character
                    swap(ch, left, left + 1);
                    moves++;
                } else {
                    // Move the matching character to the right position
                    while (k < right) {
                        swap(ch, k, k + 1);
                        moves++;
                        k++;
                    }
                    left++;
                    right--;
                }
            }
        }

        return moves;
    }

    private void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
