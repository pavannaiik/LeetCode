/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    unordered_map<int,Node*>map;
    Node* cloneGraph(Node* node) {
        if(node==NULL) return node;
        if(map.find(node->val)!=map.end()){
            return map[node->val];
        }
        Node* copy = new Node(node->val, vector<Node*>());
        map[node->val]=copy;
        for(Node* neigh:node->neighbors){
            copy->neighbors.push_back(cloneGraph(neigh));
        }
        return copy;
    }
};