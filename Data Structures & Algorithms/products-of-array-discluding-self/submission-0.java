class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int p = 1;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                p *= nums[j];
            }
            res[i] = p;
        }

        return res;
    }
}
