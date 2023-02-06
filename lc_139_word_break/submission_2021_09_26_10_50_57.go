package lc_139_word_break

func wordBreak(s string, wordDict []string) bool {
	/*
		s只有一个字符时, 判断s是否在dict中
		有两个字符时:
			s[0] 在 && s[1] 在
			s[0:1] 在
		dp[i] 到i为止是否可拆分
		dp[i] = dp[j] && s[j+1:i] in dict (j < i)
	*/
	if len(s) == 0 {
		return false
	}
	mp := make(map[string]bool, len(wordDict))
	for _, word := range wordDict {
		mp[word] = true
	}

	dp := make([]bool, len(s)+1)
	dp[0] = true
	for i := 0; i < len(s); i++ {
		for j := i - 1; j >= -1; j-- {
			if dp[j+1] && mp[s[j+1:i+1]] {
				dp[i+1] = true
				break
			}
		}
	}
	return dp[len(s)]
}
