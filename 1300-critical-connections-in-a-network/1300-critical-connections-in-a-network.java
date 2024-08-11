class Solution {
    int time = 1;
    List<List<Integer>>criticalConn = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] timeOfInsertion = new int[n];
        int[] lowTime = new int[n];

        List<Integer>adj[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]= new ArrayList<>();
        }
        for(List<Integer>connection:connections){
            adj[connection.get(0)].add(connection.get(1));
            adj[connection.get(1)].add(connection.get(0));
        }
        boolean[] visited = new boolean[n];
     
        dfs(0, -1, adj, timeOfInsertion, lowTime, visited);
        return criticalConn;


    }
    public void dfs(int node, int parent,List<Integer>adj[], int[] timeOfInsertion, int[] lowTime, boolean[] visited ){
        visited[node]=true;
        timeOfInsertion[node] = time;
        lowTime[node] = time;
        time++;
        for(int neighbor:adj[node]){
            if(neighbor == parent){
                continue;
            }
            if(!visited[neighbor]){
                dfs(neighbor, node, adj, timeOfInsertion, lowTime, visited);
                lowTime[node]= Math.min(lowTime[node],lowTime[neighbor]);
                //node to neighbor
                if(timeOfInsertion[node] < lowTime[neighbor]){
                    criticalConn.add(new ArrayList<>(Arrays.asList(node, neighbor)));
                }
            }else{
                lowTime[node]= Math.min(lowTime[node],lowTime[neighbor]);
            }
                
        }
        
        
    }
}