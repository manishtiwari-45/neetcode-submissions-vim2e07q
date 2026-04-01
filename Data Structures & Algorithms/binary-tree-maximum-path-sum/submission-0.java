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

    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
    private int solve(TreeNode root){
        if(root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        int both_side_good = left + right + root.val;
        int only_one_good = Math.max(left,right) + root.val;
        int only_root_good = root.val;

        maxSum = Math.max(maxSum,Math.max(both_side_good, Math.max(only_one_good,only_root_good)));

        return Math.max(only_one_good,only_root_good);
    }

}
