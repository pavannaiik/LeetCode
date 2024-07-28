class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int rows = graph.length;
        int[] colors = new int[rows];
        Arrays.fill(colors, -1);
        for(int i=0;i<rows;i++){
            if(colors[i]==-1){
                if(!colorGraph(graph, i, colors)){
                    return false;
                }
            }
        }
        return true;
        
    }
    public boolean colorGraph(int[][] graph, int start, int[] colors){
        Queue<Integer>queue = new LinkedList<>();
        queue.add(start);
        colors[start]=0;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int neighbor:graph[temp]){
                if(colors[neighbor] == -1){
                    colors[neighbor] = 1-colors[temp];
                    queue.add(neighbor);
                }else if(colors[neighbor]==colors[temp]){
                    return false;
                }
            }
        }
        return true;
    }
}
