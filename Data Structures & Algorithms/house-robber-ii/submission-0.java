class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) return nums[0];

        int case1 = robLinear(nums, 0, n - 2); // exclude last
        int case2 = robLinear(nums, 1, n - 1); // exclude first

        return Math.max(case1, case2);
    }

    private int robLinear(int[] nums, int start, int end) {

        int n = end - start + 1;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = nums[start];

        for (int i = 2; i <= n; i++) {
            int steal = nums[start + i - 1] + dp[i - 2];
            int skip = dp[i - 1];

            dp[i] = Math.max(steal, skip);
        }

        return dp[n];
    }
}