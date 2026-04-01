class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        int i = 0;
        int j = n-1;

        while(i < j){
            int height = Math.min(heights[i], heights[j]);
            int width = j - i;
            int currArea = height*width;
            area = Math.max(area,currArea);
            if(heights[i] <= heights[j]){
                i++;
            } else{
                j--;
            }
        }
        return area;
    }
}
