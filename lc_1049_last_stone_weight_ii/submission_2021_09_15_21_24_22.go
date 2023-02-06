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
	dp := make([]int, halfSum+1)


	for i := 0; i < len(stones); i++ {
		stone := stones[i]
		for j := halfSum; j >= stone; j-- {
			dp[j] = max(dp[j-stone]+stone, dp[j])
		}
	}
	
	for i := halfSum; i >= 0; i-- {
		if dp[i] > 0 {
			return sum - 2*dp[i]
		}
	}
	return sum
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
