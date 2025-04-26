class Solution {
    private List<String>result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>>map = new HashMap<>();
        for(List<String>ticket :tickets){
            if(!map.containsKey(ticket.get(0))){
                map.put(ticket.get(0), new PriorityQueue<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        getItinary(map, "JFK");
        return result;
    }
    public void getItinary(HashMap<String, PriorityQueue<String>>map, String source){
       while(map.containsKey(source) && !map.get(source).isEmpty()){
        getItinary(map, map.get(source).poll());
       }
       result.add(0,source);
    }
}