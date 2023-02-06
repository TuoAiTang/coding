

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
    public static String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
        	TreeNode cur = q.remove();
        	if(cur == null){
        		sb.append("# ");	//note the space
        		continue;
        	}
        	sb.append(cur.val + " ");
        	q.add(cur.left);
        	q.add(cur.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	if(data.equals("")) return null;
        String [] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i = 0; i < str.length - 2; i += 2){
        	TreeNode cur = q.remove();
        	if(!str[i + 1].equals("#")){
        		cur.left = new TreeNode(Integer.valueOf(str[i + 1]));
        		q.add(cur.left);
        	}
        	if(!str[i + 2].equals("#")){
        		cur.right = new TreeNode(Integer.valueOf(str[i + 2]));
        		q.add(cur.right);
        	}
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));