package lc_12_integer_to_roman

var m = map[int]byte{
	1:    'I',
	5:    'V',
	10:   'X',
	50:   'L',
	100:  'C',
	500:  'D',
	1000: 'M',
}
var base = []int{1000, 500, 100, 50, 10, 5, 1}

func intToRoman(num int) string {
	for _, b := range base {
		if num >= b {
			mod := num / b
			r := num - mod*b
			return dup(m[b], mod) + intToRoman(r)
		}

		nextB := 0
		if b == 1000 || b == 500 {
			nextB = 100
		}

		if b == 100 || b == 50 {
			nextB = 10
		}

		if b == 10 || b == 5 {
			nextB = 1
		}

		if nextB > 0 {
			if num+nextB >= b {
				return string(m[nextB]) + string(m[b]) + intToRoman(num-b+nextB)
			}
		}
	}
	return ""
}

func dup(b byte, n int) string {
	var res []byte
	for i := 0; i < n; i++ {
		res = append(res, b)
	}
	return string(res)
}