package lc_6_zigzag_conversion

func convert(s string, numRows int) string {
    if numRows <=1 {
        return s
    }
	lines := make([]string, numRows)
	for i := 0; i < len(s); {
		// push vertical line
		if i%(numRows-1) == 0 {
			for j := 0; j < numRows && i < len(s); j++ {
				lines[j] += string(s[i])
				i++
			}
			continue
		}
		// push mid gap
		for k := 0; k < numRows-2 && i < len(s); k++ {
			c := numRows - k - 2
			lines[c] += string(s[i])
			i++
		}
	}
	return strings.Join(lines, "")
}