package lc_14_longest_common_prefix

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 || len(strs[0]) == 0 {
		return ""
	}
	base := strs[0]
	maxLen := 0
	maxPrefix := ""

	for left, right := 0, 0; right < len(base); {
		allHas := true
		for _, str := range strs {
			if !strings.HasPrefix(str, base[left:right+1]) {
				allHas = false
				break
			}
		}
		if allHas {
			prefix := base[left : right+1]
			if len(prefix) > maxLen {
				maxLen = len(prefix)
				maxPrefix = prefix
			}
			right++
		} else {
			break
		}
	}

	return maxPrefix
}
