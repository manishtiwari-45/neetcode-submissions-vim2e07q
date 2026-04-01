class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int profit = 0;
        
        while(right < prices.length){
            if(prices[right]>prices[left]){
                int mp = prices[right] - prices[left];
                profit = Math.max(profit, mp);
            } else{
                left = right;
            }
            right++;
        }
        return profit;
    }
}
