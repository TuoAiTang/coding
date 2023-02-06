package lc_剑指 Offer II 103_gaM7Ch

func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1)
	dp[0] = 0
	for i := 1; i <= amount; i++ {
		dp[i] = -1
	}
	for _, coin := range coins {
		if coin <= amount {
			dp[coin] = 1
		}
	}
	for i := 1; i <= amount; i++ {
		for _, coin := range coins {
			if i <= coin {
				continue
			}
			if dp[i-coin] == -1 {
				continue
			}
			if dp[i] == -1 {
				dp[i] = dp[i-coin]+1
			} else if dp[i-coin]+1 < dp[i]{
				dp[i] = dp[i-coin]+1
			}
		}
	}
	return dp[amount]
}
