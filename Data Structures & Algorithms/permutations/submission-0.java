class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(),visited);
        return result;
    }
    public void backtrack(int[] nums, List<Integer> current, boolean[] visited){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            current.add(nums[i]);
            backtrack(nums,current,visited);
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
