class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(new ArrayList(), nums, 0);
        return result;
    }
    private void backtrack(List<Integer> current, int[] nums, int start){
        
        result.add(new ArrayList<>(current));

        for(int i = start; i<nums.length; i++){
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
            current.add(nums[i]); 
            backtrack(current, nums, i+1);  
            current.remove(current.size()-1);  
        }
    }
}

    
    