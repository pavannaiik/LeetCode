class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String, Double>>graph = buildGraph(equations, values);

        double[] ans = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            List<String>query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            ans[i]= dfs(start,end,graph, new HashSet<>());
        }
        return ans;

    }
    public double dfs(String start, String end, Map<String,Map<String, Double>>graph, HashSet<String>visited){
        if(!graph.containsKey(start)|| !graph.containsKey(end)){
            return -1.0;
        }
        if(start.equals(end)) return 1.0;
        visited.add(start);
        for(Map.Entry<String, Double>neighbor:graph.get(start).entrySet()){
            if(!visited.contains(neighbor.getKey())){
                double result = dfs(neighbor.getKey(), end,graph, visited);
                if(result != -1.0){
                    return result * neighbor.getValue();                }
            }
        }
        return -1.0;
    }
    public static Map<String,Map<String, Double>> buildGraph(List<List<String>> equations, double[] values){
        Map<String,Map<String, Double>> map = new HashMap<>();
        int i=0;
        for(List<String>list : equations){
            String a = list.get(0);
            String b = list.get(1);
            Double val = values[i++];
            map.putIfAbsent(a, new HashMap<>());
            map.putIfAbsent(b, new HashMap<>());
            map.get(a).put(b,val);
            map.get(b).put(a,1.0/val);
        }
        return map;
    }
}