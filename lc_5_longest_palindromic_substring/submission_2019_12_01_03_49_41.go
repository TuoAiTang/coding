package lc_5_longest_palindromic_substring

func longestPalindrome(s string) string {
	if s == "" {
		return s
	}

	start, end := 0, 0
	maxLen := 1
	for i := 0; i < len(s); i++ {
		l := int(math.Max(float64(develop(s, i, i)), float64(develop(s, i, i+1))))
		if l > maxLen {
			maxLen = l
			if l%2 == 0 {
				start = i - l/2 + 1
			} else {
				start = i - l/2
			}
			end = i + l/2
		}
	}
	return s[start : end+1]
}

func develop(s string, left int, right int) int {
	for left >= 0 && right < len(s) && s[left] == s[right] {
		left--
		right++
	}
	return right - left - 1
}
