package lc_877_stone_game


func stoneGame(piles []int) bool {
	dp := make([][]int, len(piles))
	for i := 0; i < len(piles); i++ {
		dp[i] = make([]int, len(piles))
		dp[i][i] = piles[i]
	}
	for l := 2; l <= len(piles); l++ {
		for i := 0; i+l-1 < len(piles); i++ {
			j := i + l - 1
			dp[i][j] = max(piles[i]-dp[i+1][j], piles[j]-dp[i][j-1])
		}
	}

	return dp[0][len(piles)-1] > 0
}

func max(i, j int) int {
	if i > j {
		return i
	}
	return j
}