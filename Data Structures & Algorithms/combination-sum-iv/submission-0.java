class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // the dp array stores dp[i] number of index's 
        // dp array keeps track of the no of ways to solve it

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) dp[i] += dp[i - num];
            }
        }
        // target returns the number of ways to give a target val
        return dp[target];
    }
}
