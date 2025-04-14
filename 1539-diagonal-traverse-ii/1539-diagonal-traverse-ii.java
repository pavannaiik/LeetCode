class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer>ans = new ArrayList<>();
        Queue<int[]>queue = new LinkedList<>();
        int n = nums.size();
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            ans.add(nums.get(row).get(col));
            if(col==0 && row+1 < n) queue.add(new int[]{row+1, col});
            if(col+1 < nums.get(row).size()) queue.add(new int[]{row,col+1});
        }
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}