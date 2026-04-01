class Solution {

    public int search(int[] nums, int target) {
        int pivot = findMinIndex(nums);
        int n = nums.length;

        int idx = -1;
        idx = binarySearch(nums, 0, pivot-1, target);
        if(idx != -1){
            return idx;
        }
        idx = binarySearch(nums, pivot, n-1,target);
        return idx;
    }

    private int findMinIndex(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1;
    }
}