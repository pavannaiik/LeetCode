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
        if(root == null) return "N,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String>queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return backtrackToBuildTree(queue);
    }
    public TreeNode backtrackToBuildTree(Queue<String> queue){
        String curNode = queue.poll();
        if(curNode.equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(curNode));
        root.left = backtrackToBuildTree(queue);
        root.right = backtrackToBuildTree(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));