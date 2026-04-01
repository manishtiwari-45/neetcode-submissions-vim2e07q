class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        for(int num : piles){
            right = Math.max(right, num);
        }

        int ans = -1;

        while(left <= right){

            int mid = left + (right - left) / 2;
            long hoursReq = findHours(piles, mid);
            if(hoursReq > h){
                left = mid + 1;
            }else{
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }

    private long findHours(int[] piles, int speed){
        long hour = 0;
        for(int pile : piles){
            hour += pile / speed;
            if(pile % speed != 0){
                hour++;
            }
        }

        return hour;
    }
}