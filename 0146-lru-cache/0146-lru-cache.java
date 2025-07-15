class LRUCache {
    HashMap<Integer, Node>nodeMap;
    Node front;
    Node rear;
    int size ;
    public LRUCache(int capacity) {
        this.nodeMap = new HashMap<>();
        this.rear = new Node(-1, -1);
        this.front = new Node(-1, -1);
        this.size = capacity;
        rear.prev = front;
        front.next = rear;
    }
    
    public int get(int key) {
        if(nodeMap.containsKey(key)){
            Node cur = nodeMap.get(key);
            //when a key accessed it should be 
            //removed from the existing position and put in the front
            removeNodeFromLinkedList(cur);
            addNodeFront(cur);
            return cur.val;
        }else{
            return -1;
        }
    }
    public void removeNodeFromLinkedList(Node cur){
        cur.next.prev = cur.prev;
        cur.prev.next = cur.next;
        nodeMap.remove(cur.key);
    }
    public void addNodeFront(Node cur){
        Node frontNext = front.next;
        cur.next = frontNext;
        frontNext.prev = cur;
        front.next = cur;
        cur.prev = front;

        nodeMap.put(cur.key, cur);
    }
    
    public void put(int key, int value) {
        
        if(nodeMap.size()  > 1 && nodeMap.containsKey(key)){
            removeNodeFromLinkedList(nodeMap.get(key));
        }else if(nodeMap.size() >= size){
            //remove from the end
            removeNodeFromEnd();
        }
        Node newNode = new Node(key, value);
        addNodeFront(newNode);
    }
    public void removeNodeFromEnd(){
        Node rearPrev = rear.prev;
        rearPrev.prev.next = rear;
        rear.prev = rearPrev.prev;
        nodeMap.remove(rearPrev.key);
    }
}
class Node {
    int key;
    int val;
    Node prev;
    Node next;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */