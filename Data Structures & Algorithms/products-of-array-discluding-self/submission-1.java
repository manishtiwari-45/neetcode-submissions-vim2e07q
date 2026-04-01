class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int zeros = 0;

        int arrProd = 1;

        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                zeros++;
            } else {
                arrProd *= nums[i];
            }
        }
        
        for(int i = 0; i < n; i++){
            if(zeros > 1){
                res[i] = 0;
            } else if(zeros == 1){
                if(nums[i] == 0){
                    res[i] = arrProd;
                } else{
                    res[i] = 0;
                }
            } else {
                res[i] = arrProd/nums[i];
            }
        }
        return res;
    }
}
