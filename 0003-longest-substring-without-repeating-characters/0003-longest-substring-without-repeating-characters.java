class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        Queue<Character> queue = new LinkedList();
        for(Character ch: s.toCharArray()){
            while(queue.contains(ch)) queue.poll();
            queue.offer(ch);
            max=Math.max(max,queue.size());
        }
        return max;
    }
}