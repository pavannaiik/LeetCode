class LRUCache {
    int size;
    Map<Integer, Node>map = new HashMap<>();
    Node head, tail;
    public LRUCache(int capacity) {
        size=capacity;
        head=new Node(-1, -1);
        tail=new Node(-1, -1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node cur = map.get(key);
        removeNode(cur);
        insertNode(cur);
        return cur.value;
    }

    public void removeNode(Node cur){
        map.remove(cur.key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }
    public void insertNode(Node cur){
        map.put(cur.key, cur);
        Node nextHead = head.next;
        head.next = cur;
        cur.prev= head;
        cur.next = nextHead;
        nextHead.prev= cur;

    }
    
    public void put(int key, int value) {
        Node curNode = new Node(key,value);
        if(map.containsKey(key)){
            removeNode(map.get(key));
        }
         if(map.size()==size){
            removeNode(tail.prev);
        }
        insertNode(curNode);
    }
}

class Node{
    int key, value;
    Node next, prev;
    Node(int key, int value){
        this.key=key;
        this.value=value;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */