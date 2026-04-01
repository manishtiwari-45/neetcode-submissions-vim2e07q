class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), 0, target, candidates);
        return result;
    }
    private void backtrack(List<Integer> current, int start, int target, int[] nums){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0){
            return;
        }
        for(int i = start; i<nums.length; i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i]>target){
                break;
            }

            current.add(nums[i]);
            backtrack(current, i+1,target-nums[i],nums);
            current.remove(current.size()-1);
        }
    }
}
