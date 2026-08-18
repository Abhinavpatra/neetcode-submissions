class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int delta = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min) min = prices[i];
            if(delta < prices[i] - min) delta =  prices[i] - min;
        }
        return delta;

    }
}
