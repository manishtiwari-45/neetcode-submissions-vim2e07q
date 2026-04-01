class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int firstNum = 0; firstNum < nums.length; firstNum++){
            int secondNum = target - nums[firstNum];
            if(!map.containsKey(secondNum)){
                map.put(nums[firstNum], firstNum);
                
            }else {
                return new int[]{map.get(secondNum), firstNum};
            }
        }
        return new int[] {};
    }
}
