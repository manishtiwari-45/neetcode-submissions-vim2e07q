public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#,");
                continue;
            }
            sb.append(node.val).append(",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int idx = 1;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            // Left child
            if (idx < values.length && !values[idx].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(values[idx]));
                queue.offer(curr.left);
            }
            idx++;

            // Right child
            if (idx < values.length && !values[idx].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(values[idx]));
                queue.offer(curr.right);
            }
            idx++;
        }
        return root;
    }
}