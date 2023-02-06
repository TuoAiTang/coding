package lc_7_reverse_integer

func reverse(x int) int {
    if x == 0 {
        return 0
    }
    negaFlag := x < 0
    if negaFlag {
        x = -x
    }
    var nums []int
    for x != 0 {
        nums = append(nums, x % 10)
        x /= 10
    }
    radix := 1
    for i := len(nums) - 1; i >= 0; i-- {
        num := nums[i]
        x += radix * num
        if x < 0 {
            return 0
        }
        radix *= 10
    }
    if x > (1 << 31 -1) || x < -(1 << 31) {
        return 0
    }
    if negaFlag {
        return -x
    }
    return x
}