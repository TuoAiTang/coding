package lc_122_best_time_to_buy_and_sell_stock_ii

func maxProfit(prices []int) int {
	if len(prices) < 2 {
		return 0
	}

	dp := make([][]int, len(prices))
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 2)
	}

	// dp[i][0] -- i天不持股的最大收益
	// dp[i][1] -- i天持股的最大收益

	// res = dp[len(prices)-1][0]

	dp[0][0] = 0
	dp[0][1] = -prices[0]

	for i := 1; i < len(prices); i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
		dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i])
	}

	return dp[len(prices)-1][0]
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}