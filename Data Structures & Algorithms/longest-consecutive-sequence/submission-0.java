class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int maxCount = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int currentNum = num;
                int count = 1;
            
                while(set.contains(currentNum + 1)){
                    count++;
                    currentNum++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
