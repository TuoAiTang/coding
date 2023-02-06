package lc_28_find_the_index_of_the_first_occurrence_in_a_string


func strStr(haystack string, needle string) int {
	if len(needle) == 0 {
		return 0
	}
    if len(haystack) < len(needle)  {
        return -1
    }
	for i := 0; i < len(haystack); i++{
		has := true
		for j := 0; j < len(needle); j++ {
			if i + j >= len(haystack) || haystack[i+j] != needle[j] {
				has = false
				break
			}
		}
		if has {
			return i
		}
	}
	return -1
}