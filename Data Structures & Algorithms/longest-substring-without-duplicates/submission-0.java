class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxWindow = 0;
        int n = s.length();
        for(int i =0; i<n; i++){
            Set<Character> set = new HashSet<>();
            int currWindow = 0;
            for(int j = i; j < n; j++){
                char temp = s.charAt(j);
                if(set.contains(temp)){
                    break;
                }
                set.add(temp);
                currWindow = j-i+1;
                maxWindow = Math.max(currWindow,maxWindow);
            }
        }
        return maxWindow;
    }
}
