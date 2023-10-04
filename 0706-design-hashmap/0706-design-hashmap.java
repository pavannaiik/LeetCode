class MyHashMap {
    List<MapNew>list ;
    public MyHashMap() {
        list = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        int f=0;
        for(MapNew m:list){
            if(m.key==key){
               m.value =value;
                f=1;
                break;
            }
        }
        if(f==0)
        list.add(new MapNew(key,value));
    }
    
    public int get(int key) {
        for(MapNew m:list){
            if(m.key==key){
                return m.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        for(MapNew m:list){
            if(m.key==key){
                list.remove(m);
                break;
            }
        }
    }
}

class MapNew{
    int key;
    int value;
    MapNew(int key,int value){
        this.key=key;
        this.value = value;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */