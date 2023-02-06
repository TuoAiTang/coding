package lc_70_climbing_stairs

func climbStairs(n int) int {
	// dp[n] = 爬到n级楼梯的种类
	// dp[i] = dp[i-1]+dp[i-2]
	if n == 1 {
		return 1
	}
	if n == 2 {
		return 2
	}
	dp := make([]int, n+1)
	dp[1] = 1
	dp[2] = 2
	for i := 3; i <= n; i++ {
		dp[i] = dp[i-1]+dp[i-2]
	}
	return dp[n]
}

func max(a, b int) int {
	return int(math.Max(float64(a), float64(b)))
}

func min(a, b int) int {
	return int(math.Min(float64(a), float64(b)))
}

