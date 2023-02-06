package lc_1143_longest_common_subsequence

func longestCommonSubsequence(text1 string, text2 string) int {
	// 最长的公共子序列一定包含较短的公共子序列
	// dp[i][j] text1到i为止, text2到j为止 最长的公共子序列长度
	// dp[i][j] = dp[i-1][j-1] + 1 (if text1[i] == text2[j])
	// dp[i][j] = max(dp[i][j-1], dp[i-1][j]

	if len(text1) == 0 || len(text2) == 0 {
		return 0
	}
	dp := make([][]int, len(text1))
	for i := range dp {
		dp[i] = make([]int, len(text2))
	}

	if text1[0] == text2[0] {
		dp[0][0] = 1
	}

	for i := 1; i < len(text1); i++ {
		if text1[i] == text2[0] {
			dp[i][0] = 1
		} else {
			dp[i][0] = dp[i-1][0]
		}
	}

	for i := 1; i < len(text2); i++ {
		if text1[0] == text2[i] {
			dp[0][i] = 1
		} else {
			dp[0][i] = dp[0][i-1]
		}
	}

	for i := 1; i < len(text1); i++ {
		for j := 1; j < len(text2); j++ {
			if text1[i] == text2[j] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
			}
		}
	}

	return dp[len(text1)-1][len(text2)-1]
}


func max(a, b int) int {
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
