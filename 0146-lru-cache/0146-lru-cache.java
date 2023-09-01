class LRUCache {
    
    private int size;
    HashMap<Integer,Node>map;
    Node front;
    Node rear;
    public LRUCache(int capacity) {
        size=capacity;
        map = new HashMap<>();
        front =new Node(-1,-1);
        rear = new Node(-1,-1);
        front.next = rear;
        rear.prev = front;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            remove(cur);
            insert(cur);
            return cur.val;
        }else{
            return -1;
        }
        
    }
    public void insert(Node node){
        
        // Node headNext = head.next;
        // headNext.prev = node;
        // node.next = headNext;
        // head.next = node;
        // headNext.prev = node;
        // node.prev = head;

        map.put(node.key,node);
        Node frontNext = front.next;
        front.next= node;
        node.prev = front;
        node.next=frontNext;
        frontNext.prev = node;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
           remove(map.get(key));
        }
        if(map.size()== size){
                remove(rear.prev);
            }
        
        insert(new Node(key,value));
    }
    public void remove(Node cur){
        map.remove(cur.key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }
    
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