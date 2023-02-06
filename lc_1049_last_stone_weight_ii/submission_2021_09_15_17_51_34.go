package lc_1049_last_stone_weight_ii

func lastStoneWeightII(stones []int) int {
	// 0-1背包 容量 sum/2
	// 价值数组: stones
	// 重量数组: stones

	sum := 0
	for _, s := range stones {
		sum += s
	}

	halfSum := sum / 2
	// ans = dp[n][halfSum]
	dp := make([][]int, len(stones)+1)
	for i := 0; i <= len(stones); i++ {
		dp[i] = make([]int, halfSum+1)
	}

	for i := 0 ; i <= len(stones); i++ {
		dp[i][0] = 0
	}

	for i := 0 ; i <= halfSum; i++ {
		dp[0][i] = 0
	}
	
	for i := 1; i <= len(stones); i++ {
		for j := 1; j <= halfSum; j++ {
			if stones[i-1] <= j {
				dp[i][j] = max(dp[i-1][j-stones[i-1]]+stones[i-1], dp[i-1][j])
			} else {
				dp[i][j] = dp[i-1][j]
			}
		}
	}
	return sum - 2*dp[len(stones)][halfSum]
}

func max (a, b int) int {
	if a < b {
		return b
	}
	return a
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
