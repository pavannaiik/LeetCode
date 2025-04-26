class Solution {
    private LinkedList<String> result = new LinkedList<>();
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        // Build the graph: from -> sorted list of to
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        
        dfs("JFK");
        return result;
    }
    
    private void dfs(String source) {
        PriorityQueue<String> destinations = graph.get(source);
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next);
        }
        result.addFirst(source); // add to front when dead-end
    }
}
