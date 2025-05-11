/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "N,";
        return root.val+","+serialize(root.left)+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        Queue<String>nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
    public TreeNode buildTree(Queue<String>nodes){
        String val = nodes.poll();
        if(val.equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left=buildTree(nodes);
        root.right=buildTree(nodes);
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));