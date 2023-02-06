

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
        serialize(root, sb);
        return sb.toString();
    }
    
    public void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("# ");
            return;
        }
        sb.append(root.val + " ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int [] pt = {0};
        String[] dataArray = data.split(" ");
        return deserialize(dataArray, pt);
    }
    
    public TreeNode deserialize(String[] dataArray, int[] pt){
        String s = dataArray[pt[0]];
        pt[0] ++;
        if(s.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(dataArray, pt);
        root.right = deserialize(dataArray, pt);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));