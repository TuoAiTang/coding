package lc_5_longest_palindromic_substring

func longestPalindrome(s string) string {
	if s == "" {
		return s
	}
	dp := make([][]bool, len(s))
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]bool, len(s))
		dp[i][i] = true
	}

	start, end := 0, 0
	for l := 2; l <= len(s); l++ {
		for i := 0; i <= len(s)-l; i++ {
			j := i + l - 1
			if s[i] == s[j] {
				if l == 2 {
					start, end = i, j
					dp[i][j] = true
					continue
				}
				if dp[i+1][j-1] {
					start, end = i, j
					dp[i][j] = true
				}
			}
		}
	}

	return s[start : end+1]
}
