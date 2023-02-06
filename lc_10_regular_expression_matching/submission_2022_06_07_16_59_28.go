package lc_10_regular_expression_matching

func isMatch(s string, p string) bool {
	m := len(s)
	n := len(p)

	dp := make([][]int, m+1)
	for i := range dp {
		dp[i] = make([]int, n+1)
	}

	dp[0][0] = 1

	match := func(i, j int) bool {
		if i == 0 {
			return false
		}

		if p[j-1] == '.' {
			return true
		}

		return s[i-1] == p[j-1]
	}

	for i := 0; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if p[j-1] == '*' {
				dp[i][j] |= dp[i][j-2]
				if match(i, j-1) {
					dp[i][j] |= dp[i-1][j]
				}
			} else {
				if match(i, j) {
					dp[i][j] |= dp[i-1][j-1]
				}
			}
		}
	}

	return dp[m][n] == 1
}