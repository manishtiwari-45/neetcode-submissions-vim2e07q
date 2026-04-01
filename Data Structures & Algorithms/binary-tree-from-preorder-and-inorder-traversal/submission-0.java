/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] pre, int[] in, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = pre[idx++];  

        TreeNode root = new TreeNode(rootVal);

        int i = start;
        for (; i <= end; i++) {
            if (in[i] == rootVal) break;
        }

        root.left = build(pre, in, start, i - 1);
        root.right = build(pre, in, i + 1, end);

        return root;
    }
}