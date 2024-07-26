class Solution {
    Set<Integer>set = new HashSet<>();
    public int findCircleNum(int[][] isConnected) {
        
        List<List<Integer>>adjList = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            List<Integer>list = new ArrayList<>();
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1){
                    list.add(j);
                }
            }
            adjList.add(list);
        }
        int ans =0;
        for(int i=0;i<adjList.size();i++){
                if(!set.contains(i)){
                ans++;
                dfs(i, adjList);
            }
        }
        return ans;

    }
    public void dfs(int start, List<List<Integer>>adjList){{
        set.add(start);
        for(int node:adjList.get(start)){
                if(!set.contains(node)){
                dfs(node, adjList);
            }
        }
    }

    }
}