package lc_189_rotate_array

func rotate(nums []int, k int)  {
    n := len(nums)
	if n < 2 || k == 0 {
		return
	}
	k %= n
	left, right := 0, n - k
	for i := 0; i < k; i++ {
		nums[left], nums[right] = nums[right], nums[left]
		left++
		right++
	}
	rotate(nums[left:], k)
}