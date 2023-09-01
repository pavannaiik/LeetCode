class LRUCache {
    
    //size to keep know the capacity 
    private int size;
    //create a hashmap which stores keys and Nodes
    HashMap<Integer,Node>map;
    //since we need doubly linkedlist create two nodes front and rear
    Node front;
    Node rear;
    public LRUCache(int capacity) {
        //initialize size , map, front ,rear and point front and rear each other
        size=capacity;
        map = new HashMap<>();
        front =new Node(-1,-1);
        rear = new Node(-1,-1);
        front.next = rear;
        rear.prev = front;
    }
    
    public int get(int key) {
        // in get we check the key exist in map if it exist then we remove it from map and add the node to the front of the doublylinked list so  here remove method takes care of removing it from ll and map
        if(map.containsKey(key)){
            Node cur = map.get(key);
            remove(cur);
            insert(cur);
            return cur.val;
        }else{
            //else we return -1 as mentioned in question
            return -1;
        }
        
    }
    public void insert(Node node){
        
        // in insert we insert key and node into map first 
        // we have three nodes now so map each other 
        map.put(node.key,node);
        Node frontNext = front.next;
        front.next= node;
        node.prev = front;
        node.next=frontNext;
        frontNext.prev = node;
    }
    
    
    public void put(int key, int value) {
        // in put we check if the key contains in map if yes then we remove it from map add ll
        // then we add it map and ll at the front
        if(map.containsKey(key)){
           remove(map.get(key));
        }
        // if map size is full then we remove the last element which is LRU which is present at rear.prev
        if(map.size()== size){
                remove(rear.prev);
            }
        // insert at the front
        insert(new Node(key,value));
    }
    // remove we remove from map and we map node last and next node with each other
    public void remove(Node cur){
        map.remove(cur.key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }
    
    // create a class with node requirement
    private class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */