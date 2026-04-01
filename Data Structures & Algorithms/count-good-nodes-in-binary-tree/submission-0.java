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
    int count;

    public int goodNodes(TreeNode root) {
        int currMax = Integer.MIN_VALUE;
        backtrack(root, currMax);
        return count;
    }

    private void backtrack(TreeNode root, int currMax) {
        if (root == null) return;

        if (root.val >= currMax) {
            count++;
            currMax = root.val;
        }

        backtrack(root.left, currMax);
        backtrack(root.right, currMax);
    }
}
