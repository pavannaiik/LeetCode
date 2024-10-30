/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
       Queue<Node>queue=new LinkedList<>();
       queue.add(root);
       while(!queue.isEmpty()){
        int size =queue.size();
        for(int i=0;i<size;i++){
            Node t = queue.poll();
            if(i==size-1){
                t.next=null;
            }else{
                t.next=queue.peek();
            }
            if(t.left!=null){
                queue.add(t.left);
            }
            if(t.right!=null){
                queue.add(t.right);
            }
        }
       }
       return root;
    }
}