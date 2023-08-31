class TimeMap {

    Map<String,TreeMap<Integer,String>> timeMap;
    public TimeMap() {
        timeMap = new TreeMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
             timeMap.put(key, new TreeMap<>());
        }
         timeMap.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
       if(!timeMap.containsKey(key)) return "";
        Integer floorKey = timeMap.get(key).floorKey(timestamp);
        if(floorKey!= null){
            return timeMap.get(key).get(floorKey);
        }
        return "";
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */