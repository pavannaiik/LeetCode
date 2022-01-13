class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character>queue=new LinkedList();
        int res=0;
        for(Character ch:s.toCharArray()){
            while(queue.contains(ch))
                queue.poll();
            queue.offer(ch);
            res=Math.max(queue.size(),res);
        }
        return res;
    }
}
