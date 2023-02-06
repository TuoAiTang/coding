package lc_746_min_cost_climbing_stairs


func minCostClimbingStairs(cost []int) int {
	// dp[i] 到第i级台阶需要的最少花费
	// dp[i] = min(dp[i-1]+cost[i], dp[i-2]+cost[i])
	// dp[0] = 0, dp[1]=0, dp[2]=min(dp[0]+cost[0], dp[1]+cost[1])
	// ans = min(dp[i]+cost[i], dp[i-1]+cost[i-1])
	ans := 0
	preAns := 0
	prePreAns := 0
	for i := 2; i < len(cost)+1; i++ {
		ans = min(preAns+cost[i-1], prePreAns+cost[i-2])
		prePreAns = preAns
		preAns = ans
	}
	return ans
}

func max(a, b int) int {
	return int(math.Max(float64(a), float64(b)))
}

func min(a, b int) int {
	return int(math.Min(float64(a), float64(b)))
}

