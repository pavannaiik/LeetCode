class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer>pq= new PriorityQueue<>((a,b)->b-a);
        int start=0, end=0;
        for(int i=0;i<matrix.length;i++){
            int flag=0;
            for(int j=0;j<matrix[0].length;j++){
                pq.add(matrix[i][j]);
                start=i;
                end=j;
                if(pq.size() == k){
                    flag=1;
                    break;
                }
            }
            if(flag==1) break;
        }
        end=end+1;
        for(int i=start;i<matrix.length;i++){
            for(int j=end;j<matrix[0].length;j++){
                pq.add(matrix[i][j]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
            end=0;
        }
        if(!pq.isEmpty()) return pq.peek();
        return -1;
    }
}