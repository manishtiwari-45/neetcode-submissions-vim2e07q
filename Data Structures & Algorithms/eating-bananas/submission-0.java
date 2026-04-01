class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int ans = r;

        while(l <= r){
            int mid = l + (r-l)/2;

            long totalT = 0;
            for(int p:piles){
                totalT += Math.ceil((double)p/mid);
            }
            if(totalT <= h){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}
