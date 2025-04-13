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
        HashMap<Integer,Node>map = new HashMap<>();
        return dfs(node, map);
    }
    public Node dfs(Node head, HashMap<Integer,Node>map){
        if(head==null) return null;
        if(map.containsKey(head.val)){
            return map.get(head.val);
        }
        map.put(head.val, new Node(head.val));
        for(Node node: head.neighbors){
            map.get(head.val).neighbors.add(dfs(node, map));
        }
        return map.get(head.val);
    }
}