class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = nums[0];
        for(int num:nums){
            max = Math.max(num, max);
        }
        int L = (Integer.toBinaryString(max)).length();
        int maxXor = 0;
        TrieNode root = new TrieNode();
        for(int num:nums){
            TrieNode node = root, xorNode = root;
            int curXor =0;
            for(int i= L-1;i>=0;i--){
                int bit = (num >> i) &1;
                int toggledBit = bit ^1;
                if(node.children[bit]==null){
                    TrieNode newNode = new TrieNode();
                    node.children[bit]= newNode;
                }
                node = node.children[bit];
                if(xorNode.children[toggledBit]!=null){
                    curXor |= (1<<i);
                    xorNode = xorNode.children[toggledBit];
                }else{
                    xorNode = xorNode.children[bit];
                }
            }
            maxXor = Math.max(maxXor, curXor);
        }
        return maxXor;

    }
}
class TrieNode{
    TrieNode[] children = new TrieNode[2];
}