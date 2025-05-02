class Solution {
    private void dfs(int node, Map<Integer,List<Integer>>adjList, boolean[] visited){
        visited[node]=true;
        if(!adjList.containsKey(node)){
            return;
        }
        for(int neighbor:adjList.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, adjList, visited);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int conLen = connections.length;
        if(conLen < n-1){
            return -1;
        }
        Map<Integer, List<Integer>>adjList = new HashMap<>();
        for(int[] connection: connections){
            adjList.computeIfAbsent(connection[0], k->new ArrayList<>()).add(connection[1]);
            adjList.computeIfAbsent(connection[1], k->new ArrayList<>()).add(connection[0]);
        }

        int numberOfConnectedComponents =0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                numberOfConnectedComponents++;
                dfs(i, adjList, visited);
            }
        }
        return numberOfConnectedComponents-1;

        
    }
}