package lc_516_longest_palindromic_subsequence

func longestPalindromeSubseq(s string) int {
	// dp[i][j] = 从i到j最长的回文子序列长度
	// dp[i][j] = dp[i+1][j-1] + 2 (if s[i]==s[j])
	// dp[i][j] = max(dp[i+1][j], dp[i][j-1])
	if len(s) < 2 {
		return len(s)
	}
	dp := make([][]int, len(s))
	for i := range dp {
		dp[i] = make([]int, len(s))
		dp[i][i] = 1
	}
	for l := 2; l <= len(s); l++ {
		for i := 0; i+l-1 < len(s); i++ {
			j := i + l - 1
			if s[i] == s[j] {
				if l == 2 {
					dp[i][j] = 2
				} else {
					dp[i][j] = dp[i+1][j-1] + 2
				}
			} else {
				dp[i][j] = max(dp[i+1][j], dp[i][j-1])
			}
		}
	}
	/*
		n = 8
		ans 		= dp[0][7]
		dp[0][7]	= dp[1][6] + 2 || dp[0][6] || dp[1][7]
		dp[1][6]	= dp[2][5] + 2 || dp[1][6] || dp[0][6]
	*/
	return dp[0][len(s)-1]
}



func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
