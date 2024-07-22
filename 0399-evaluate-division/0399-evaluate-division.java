class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String, Double>>graph = buildGraph(equations, values);
        int n = queries.size();
        double[] results = new double[n];
        for(int i=0;i<n;i++){
            results[i] =  getPath(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());
        }
        return results;

    }
    public double getPath(String start, String end, Map<String,Map<String, Double>>graph, Set<String>visited){

        if(!graph.containsKey(start))
         return -1.0;
        if(graph.get(start).containsKey(end))
        return graph.get(start).get(end);
        visited.add(start);
        for(Map.Entry<String, Double>neighbour : graph.get(start).entrySet()){
            if(!visited.contains(neighbour.getKey())){
                double weight = getPath(neighbour.getKey(), end, graph, visited);
                if(weight!=-1.0){
                    return neighbour.getValue() * weight;
                }
            }
        }
        return -1.0;
        

    }
    public Map<String,Map<String,Double>> buildGraph(List<List<String>> equations, double[] values){
        Map<String,Map<String,Double>>graph = new HashMap<>();
        int i=0;
        for(List<String>list: equations){
            String u = list.get(0);
            String v = list.get(1);
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1.0/values[i++]);

        }
        return graph;
    }
}