package lc_17_letter_combinations_of_a_phone_number

var mp = map[uint8][]string{
	'2': {"a", "b", "c"},
	'3': {"d", "e", "f"},
	'4': {"g", "h", "i"},
	'5': {"j", "k", "l"},
	'6': {"m", "n", "o"},
	'7': {"p", "q", "r", "s"},
	'8': {"t", "u", "v"},
	'9': {"w", "x", "y", "z"},
}

func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}

	if len(digits) == 1 {
		return mp[digits[0]]
	}

	var res []string
	for _, char := range mp[digits[0]] {
		lastRes := letterCombinations(digits[1:])
		for _, last := range lastRes {
			res = append(res, char+last)
		}
	}
	return res
}