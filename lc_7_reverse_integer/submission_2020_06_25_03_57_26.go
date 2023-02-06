package lc_7_reverse_integer

func reverse(x int) int {
    y := 0
    for x != 0 {
        y = 10 * y + x % 10
        x /= 10
    }
    if y > (1 << 31 - 1) || -y > (1 << 31) {
        return 0
    }
    return y
}