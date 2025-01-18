/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    public void dfs(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] index = new int[1]; // Mutable index
        return dfsDeserialize(nodes, index);
    }
    public TreeNode dfsDeserialize(String[] nodes, int[] index){
        if (index[0] >= nodes.length || nodes[index[0]].equals("N")) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index[0]++]));
        root.left = dfsDeserialize(nodes, index);
        root.right = dfsDeserialize(nodes, index);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));