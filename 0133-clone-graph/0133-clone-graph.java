/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node,Node>map = new HashMap<>();
        return dfs(node, map);
    }
    public Node dfs(Node head, HashMap<Node,Node>map){
        if(head==null) return null;
        if(map.containsKey(head)){
            return map.get(head);
        }
        map.put(head, new Node(head.val));
        for(Node node: head.neighbors){
            map.get(head).neighbors.add(dfs(node, map));
        }
        return map.get(head);
    }
}