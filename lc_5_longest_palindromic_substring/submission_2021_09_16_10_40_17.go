package lc_5_longest_palindromic_substring

func longestPalindrome(s string) string {
	//bool dp[i][j]  i,j 字串是否为回文字符串
	//dp[i][j] = s[i]==s[j] && dp[i-1][j-1]

	dp := make([][]bool, len(s))
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]bool, len(s))
		dp[i][i] = true
	}


	start, end := 0, 0
	for l := 2; l <= len(s); l++ {
		for i := 0; i + l - 1 < len(s); i++ {
			j := i + l - 1
			if s[i] == s[j] {
				if l == 2 {
					start, end = i, j
					dp[i][j] = true
				} else if dp[i+1][j-1]{
					start, end = i, j
					dp[i][j] = true
				}
			}
		}
	}
	return s[start:end+1]
}
