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
	ans, prePre, pre := 0, 1, 2
	for i := 3; i <= n; i++ {
		ans = prePre + pre
		prePre = pre
		pre = ans
	}
	return ans
}

func max(a, b int) int {
	return int(math.Max(float64(a), float64(b)))
}

func min(a, b int) int {
	return int(math.Min(float64(a), float64(b)))
}

